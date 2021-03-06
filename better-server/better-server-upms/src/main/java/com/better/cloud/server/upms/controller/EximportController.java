package com.better.cloud.server.upms.controller;

import com.better.cloud.common.annotation.ControllerEndpoint;
import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.upms.Eximport;
import com.better.cloud.common.exception.BetterException;
import com.better.cloud.common.utils.BetterUtil;
import com.better.cloud.server.upms.service.IEximportService;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.wuwenze.poi.ExcelKit;
import com.wuwenze.poi.handler.ExcelReadHandler;
import com.wuwenze.poi.pojo.ExcelErrorField;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author MrBird
 */
@Slf4j
@RestController
@RequestMapping("eximport")
public class EximportController {

    @Autowired
    private IEximportService eximportService;

    @GetMapping
    public BetterResponse findEximports(QueryRequest request) {
        Map<String, Object> dataTable = BetterUtil.getDataTable(eximportService.findEximports(request, null));
        return new BetterResponse().data(dataTable);
    }

    @PostMapping("template")
    public void generateImportTemplate(HttpServletResponse response) {
        List<Eximport> list = new ArrayList<>();
        IntStream.range(0, 20).forEach(i -> {
            Eximport eximport = new Eximport();
            eximport.setField1("字段1");
            eximport.setField2(i + 1);
            eximport.setField3("mrbird" + i + "@gmail.com");
            list.add(eximport);
        });
        ExcelKit.$Export(Eximport.class, response).downXlsx(list, true);
    }

    @PostMapping("import")
    @ControllerEndpoint(exceptionMessage = "导入Excel数据失败")
    public BetterResponse importExcels(MultipartFile file) throws IOException, BetterException {
        if (file.isEmpty()) {
            throw new BetterException("导入数据为空");
        }
        String filename = file.getOriginalFilename();
        if (!StringUtils.endsWith(filename, ".xlsx")) {
            throw new BetterException("只支持.xlsx类型文件导入");
        }
        Stopwatch stopwatch = Stopwatch.createStarted();
        final List<Eximport> data = Lists.newArrayList();
        final List<Map<String, Object>> error = Lists.newArrayList();
        ExcelKit.$Import(Eximport.class).readXlsx(file.getInputStream(), new ExcelReadHandler<Eximport>() {
            @Override
            public void onSuccess(int sheet, int row, Eximport eximport) {
                eximport.setCreateTime(new Date());
                data.add(eximport);
            }

            @Override
            public void onError(int sheet, int row, List<ExcelErrorField> errorFields) {
                error.add(ImmutableMap.of("row", row, "errorFields", errorFields));
            }
        });
        if (CollectionUtils.isNotEmpty(data)) {
            this.eximportService.batchInsert(data);
        }
        ImmutableMap<String, Object> result = ImmutableMap.of(
                "time", stopwatch.stop().toString(),
                "data", data,
                "error", error
        );
        return new BetterResponse().data(result);
    }

    @PostMapping("excel")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    public void export(QueryRequest queryRequest, Eximport eximport, HttpServletResponse response) {
        List<Eximport> eximports = this.eximportService.findEximports(queryRequest, eximport).getRecords();
        ExcelKit.$Export(Eximport.class, response).downXlsx(eximports, false);
    }
}
