INSERT INTO `t_menu` VALUES (1, 0, '系统管理', '/system', 'Layout', NULL, 'el-icon-set-up', '0', 1, '2017-12-27 16:39:07', '2019-07-20 16:19:04');
INSERT INTO `t_menu` VALUES (2, 0, '系统监控', '/monitor', 'Layout', NULL, 'el-icon-data-line', '0', 2, '2017-12-27 16:45:51', '2019-01-23 06:27:12');
INSERT INTO `t_menu` VALUES (3, 1, '用户管理', '/system/user', 'better/system/user/Index', 'user:view', '', '0', 1, '2017-12-27 16:47:13', '2019-01-22 06:45:55');
INSERT INTO `t_menu` VALUES (4, 1, '角色管理', '/system/role', 'better/system/role/Index', 'role:view', '', '0', 2, '2017-12-27 16:48:09', '2018-04-25 09:01:12');
INSERT INTO `t_menu` VALUES (5, 1, '菜单管理', '/system/menu', 'better/system/menu/Index', 'menu:view', '', '0', 3, '2017-12-27 16:48:57', '2018-04-25 09:01:30');
INSERT INTO `t_menu` VALUES (6, 1, '部门管理', '/system/dept', 'better/system/dept/Index', 'dept:view', '', '0', 4, '2017-12-27 16:57:33', '2018-04-25 09:01:40');
INSERT INTO `t_menu` VALUES (10, 2, '系统日志', '/monitor/systemlog', 'better/monitor/systemlog/Index', 'log:view', '', '0', 1, '2017-12-27 17:00:50', '2019-07-22 20:22:31');
INSERT INTO `t_menu` VALUES (11, 3, '新增用户', '', '', 'user:add', NULL, '1', NULL, '2017-12-27 17:02:58', NULL);
INSERT INTO `t_menu` VALUES (12, 3, '修改用户', '', '', 'user:update', NULL, '1', NULL, '2017-12-27 17:04:07', NULL);
INSERT INTO `t_menu` VALUES (13, 3, '删除用户', '', '', 'user:delete', NULL, '1', NULL, '2017-12-27 17:04:58', NULL);
INSERT INTO `t_menu` VALUES (14, 4, '新增角色', '', '', 'role:add', NULL, '1', NULL, '2017-12-27 17:06:38', NULL);
INSERT INTO `t_menu` VALUES (15, 4, '修改角色', '', '', 'role:update', NULL, '1', NULL, '2017-12-27 17:06:38', NULL);
INSERT INTO `t_menu` VALUES (16, 4, '删除角色', '', '', 'role:delete', NULL, '1', NULL, '2017-12-27 17:06:38', NULL);
INSERT INTO `t_menu` VALUES (17, 5, '新增菜单', '', '', 'menu:add', NULL, '1', NULL, '2017-12-27 17:08:02', NULL);
INSERT INTO `t_menu` VALUES (18, 5, '修改菜单', '', '', 'menu:update', NULL, '1', NULL, '2017-12-27 17:08:02', NULL);
INSERT INTO `t_menu` VALUES (19, 5, '删除菜单', '', '', 'menu:delete', NULL, '1', NULL, '2017-12-27 17:08:02', NULL);
INSERT INTO `t_menu` VALUES (20, 6, '新增部门', '', '', 'dept:add', NULL, '1', NULL, '2017-12-27 17:09:24', NULL);
INSERT INTO `t_menu` VALUES (21, 6, '修改部门', '', '', 'dept:update', NULL, '1', NULL, '2017-12-27 17:09:24', NULL);
INSERT INTO `t_menu` VALUES (22, 6, '删除部门', '', '', 'dept:delete', NULL, '1', NULL, '2017-12-27 17:09:24', NULL);
INSERT INTO `t_menu` VALUES (24, 10, '删除日志', '', '', 'log:delete', NULL, '1', NULL, '2017-12-27 17:11:45', NULL);
INSERT INTO `t_menu` VALUES (130, 3, '导出Excel', NULL, NULL, 'user:export', NULL, '1', NULL, '2019-01-23 06:35:16', NULL);
INSERT INTO `t_menu` VALUES (131, 4, '导出Excel', NULL, NULL, 'role:export', NULL, '1', NULL, '2019-01-23 06:35:36', NULL);
INSERT INTO `t_menu` VALUES (132, 5, '导出Excel', NULL, NULL, 'menu:export', NULL, '1', NULL, '2019-01-23 06:36:05', NULL);
INSERT INTO `t_menu` VALUES (133, 6, '导出Excel', NULL, NULL, 'dept:export', NULL, '1', NULL, '2019-01-23 06:36:25', NULL);
INSERT INTO `t_menu` VALUES (135, 3, '密码重置', NULL, NULL, 'user:reset', NULL, '1', NULL, '2019-01-23 06:37:00', NULL);
INSERT INTO `t_menu` VALUES (136, 10, '导出Excel', NULL, NULL, 'log:export', NULL, '1', NULL, '2019-01-23 06:37:27', NULL);
INSERT INTO `t_menu` VALUES (148, 2, '监控中心', '/monitor/admin', 'better/monitor/admin/Index', 'mobitor:admin', '', '0', 6, '2019-07-20 19:42:07', '2019-09-01 10:48:12');
INSERT INTO `t_menu` VALUES (149, 2, '注册中心', 'http://localhost:8001/nacos', 'Layout', 'monitor:register', '', '0', 3, '2019-07-20 20:07:00', '2019-07-22 20:22:43');
INSERT INTO `t_menu` VALUES (150, 2, '登录日志', '/monitor/loginlog', 'better/monitor/loginlog/Index', 'monitor:loginlog', '', '0', 2, '2019-07-22 13:41:17', '2019-07-22 20:22:35');
INSERT INTO `t_menu` VALUES (151, 150, '删除日志', NULL, NULL, 'loginlog:delete', NULL, '1', NULL, '2019-07-22 13:43:04', NULL);
INSERT INTO `t_menu` VALUES (152, 150, '导出Excel', NULL, NULL, 'loginlog:export', NULL, '1', NULL, '2019-07-22 13:43:30', NULL);
INSERT INTO `t_menu` VALUES (153, 2, '接口文档', '/monitor/swagger', 'better/monitor/swagger/Index', 'monitor:swagger', '', '0', 7, '2019-07-22 20:59:46', '2019-09-01 10:48:16');
INSERT INTO `t_menu` VALUES (154, 0, '其他模块', '/others', 'Layout', '', 'el-icon-present', '0', 5, '2019-07-25 10:16:16', '2020-01-16 13:59:52');
INSERT INTO `t_menu` VALUES (155, 154, '导入导出', '/others/eximport', 'better/others/eximport/Index', 'others:eximport', '', '0', 1, '2019-07-25 10:19:31', NULL);
INSERT INTO `t_menu` VALUES (156, 0, '代码生成', '/gen', 'Layout', '', 'el-icon-printer', '0', 4, '2019-07-25 10:24:03', '2020-01-16 13:59:49');
INSERT INTO `t_menu` VALUES (157, 156, '生成配置', '/gen/config', 'better/gen/config/Index', 'gen:config', '', '0', 1, '2019-07-25 10:24:55', NULL);
INSERT INTO `t_menu` VALUES (158, 156, '生成代码', '/gen/generate', 'better/gen/generate/Index', 'gen:generate', '', '0', 2, '2019-07-25 10:25:26', '2019-07-25 11:13:20');
INSERT INTO `t_menu` VALUES (159, 157, '修改配置', NULL, NULL, 'gen:config:update', NULL, '1', NULL, '2019-07-26 16:22:56', NULL);
INSERT INTO `t_menu` VALUES (160, 158, '打包生成', NULL, NULL, 'gen:generate:gen', NULL, '1', NULL, '2019-07-26 16:23:38', '2019-07-26 16:23:53');
INSERT INTO `t_menu` VALUES (161, 2, '请求追踪', '/monitor/zipkin', 'better/monitor/zipkin/Index', 'monitor:zipkin', '', '0', 4, '2019-09-01 10:41:49', NULL);
INSERT INTO `t_menu` VALUES (162, 2, '日志收集', '/monitor/kibana', 'better/monitor/kibana/Index', 'monitor:kibana', '', '0', 5, '2019-09-01 10:48:07', NULL);
INSERT INTO `t_menu` VALUES (163, 1, '客户端管理', '/client', 'better/system/client/Index', 'client:view', '', '0', 5, '2019-09-26 22:58:09', NULL);
INSERT INTO `t_menu` VALUES (164, 163, '新增', NULL, NULL, 'client:add', NULL, '1', NULL, '2019-09-26 22:58:21', NULL);
INSERT INTO `t_menu` VALUES (165, 163, '修改', NULL, NULL, 'client:update', NULL, '1', NULL, '2019-09-26 22:58:43', NULL);
INSERT INTO `t_menu` VALUES (166, 163, '删除', NULL, NULL, 'client:delete', NULL, '1', NULL, '2019-09-26 22:58:55', NULL);
INSERT INTO `t_menu` VALUES (167, 163, '解密', NULL, NULL, 'client:decrypt', NULL, '1', NULL, '2019-09-26 22:59:08', NULL);
INSERT INTO `t_menu` VALUES (168, 0, '静态组件', '/components', 'Layout', '', 'el-icon-present', '0', 6, '2019-12-02 16:41:28', '2020-01-16 13:59:55');
INSERT INTO `t_menu` VALUES (169, 168, '二级菜单', '/two', 'demos/two/Index', '', '', '0', 1, '2019-12-02 16:41:51', NULL);
INSERT INTO `t_menu` VALUES (170, 169, '三级菜单', '/three', 'demos/two/three/Index', '', '', '0', 1, '2019-12-02 16:42:09', NULL);
INSERT INTO `t_menu` VALUES (171, 168, 'MarkDown', '/components/markdown', 'demos/markdown', '', '', '0', 2, '2019-12-02 16:42:34', NULL);
INSERT INTO `t_menu` VALUES (172, 168, '富文本编辑器', '/components/tinymce', 'demos/tinymce', '', '', '0', 3, '2019-12-02 16:42:50', NULL);
INSERT INTO `t_menu` VALUES (173, 0, '网关管理', '/route', 'Layout', '', 'el-icon-odometer', '0', 3, '2020-01-16 14:00:15', NULL);
INSERT INTO `t_menu` VALUES (174, 173, '网关用户', '/route/user', 'better/route/routeuser/Index', '', '', '0', 1, '2020-01-16 14:00:32', NULL);
INSERT INTO `t_menu` VALUES (175, 173, '网关日志', '/route/log', 'better/route/routelog/Index', '', '', '0', 2, '2020-01-16 14:00:47', NULL);
INSERT INTO `t_menu` VALUES (176, 173, '限流规则', '/route/ratelimitrule', 'better/route/ratelimitrule/Index', '', '', '0', 3, '2020-01-16 14:01:01', NULL);
INSERT INTO `t_menu` VALUES (177, 173, '限流日志', '/route/ratelimitlog', 'better/route/ratelimitlog/Index', '', '', '0', 4, '2020-01-16 14:01:17', NULL);
INSERT INTO `t_menu` VALUES (178, 173, '黑名单管理', '/route/blacklist', 'better/route/blacklist/Index', '', '', '0', 5, '2020-01-16 14:01:32', NULL);
INSERT INTO `t_menu` VALUES (179, 173, '黑名单日志', '/route/blocklog', 'better/route/blocklog/Index', '', '', '0', 6, '2020-01-16 14:01:49', NULL);