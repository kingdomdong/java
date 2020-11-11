-- 菜单

INSERT INTO usmsc.t_cfg_functionlist (function_id, function_name, client_type, remark, up_function_id, virtual_fg, module_type, module_key, icon, route, is_microapp) VALUES (133, '流程管理', 1, '流程管理', 14, 1, 1, '','','',NULL);

INSERT INTO usmsc.t_cfg_functionlist (function_id, function_name, client_type, remark, up_function_id, virtual_fg, module_type, module_key, icon, route, is_microapp) VALUES (13301, '流程列表', 1, '流程列表', 133, 1, 1, '','','/process/processList',1);