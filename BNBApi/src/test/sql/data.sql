insert into user_info (tenant_id, user_id, password, user_name, dept_id, dept_name, pos_id)
values('001000000','000000001', password('1'), 'admin', '000000101', 'system', '000000001');
insert into pos (tenant_id, pos_id,sec_level,pos_name) values('001000000','000000001', 1, '관리자');
insert into dept_info (tenant_id, dept_id, dept_name, par_id, seq , status, dept_code, comp_id)
    values('001000000','000000101', 'system','000000000', 0, '1', 'system', '000000101');
insert into tenant_info (tenant_id, name, alias, web_port, firewall_web_port, manager_id)
    values('001000000','SYSTEM','SYSTEM','8080','8080','000000001');