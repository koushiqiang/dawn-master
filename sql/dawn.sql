-- ----------------------------
-- 1、用户信息表
-- ----------------------------
drop table if exists sys_user;
create table sys_user (
  user_id 			bigint(20) 		not null auto_increment    comment '用户ID',
  dept_id 			bigint(20) 		default null			   comment '部门ID',
  login_name 		varchar(30) 	not null 				   comment '登录账号',
  user_name 		varchar(30) 	not null 				   comment '用户昵称',
  user_type 		varchar(2) 	    default '00' 		       comment '用户类型（00系统用户）',
  email  			varchar(50) 	default '' 				   comment '用户邮箱',
  phonenumber  		varchar(11) 	default '' 				   comment '手机号码',
  sex  		        char(1) 	    default '0' 			   comment '用户性别（0男 1女）',
  avatar            varchar(100) 	default '' 				   comment '头像路径',
  password 			varchar(50) 	default '' 				   comment '密码',
  salt 				varchar(20) 	default '' 				   comment '盐加密',
  status 			char(1) 		default '0' 			   comment '帐号状态（0正常 1停用）',
  del_flag			char(1) 		default '0' 			   comment '删除标志（0代表存在 2代表删除）',
  login_date        datetime                                   comment '最后登陆时间',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time 	    datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP    comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark 		    text			   comment '备注',
  primary key (user_id)
) engine=innodb auto_increment=100 comment = '用户信息表';

-- ----------------------------
-- 初始化-用户信息表数据
-- ----------------------------
insert into sys_user values(1,  101, 'admin', '系统管理员', '00', 'admin@163.com', '15888888888', '0', '', '29c67a30398638269fe600f73a054934', '111111', '0', '0', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '管理员');
insert into sys_user values(2,  102, 'liyx', 'liyx', '01', 'liyx@qq.com',  '15666666666', '1', '', '8e6d98b90472783cc73c17047ddccf36', '222222', '0', '0', '2020-05-22 11-33-00', 'liyx', '2020-05-22 11-33-00', 'liyx', '2020-05-22 11-33-00', '普通用户');


-- ----------------------------
-- 2、字典类型表
-- ----------------------------
drop table if exists sys_dict_type;
create table sys_dict_type
(
    dict_id          bigint(20) 		 not null auto_increment    comment '字典主键',
    dict_name        varchar(100)    default ''                 comment '字典名称',
    dict_type        varchar(100)    default ''                 comment '字典类型',
    status 			 char(1) 		 default '0'			    comment '状态（0正常 1停用）',
    create_by        varchar(64)     default ''                 comment '创建者',
    create_time      datetime      NOT NULL ON UPDATE CURRENT_TIMESTAMP   comment '创建时间',
    update_by        varchar(64) 	 default ''			        comment '更新者',
    update_time      datetime                                   comment '更新时间',
    remark 	         varchar(200) 				comment '备注',
    primary key (dict_id),
    unique (dict_type)
) engine=innodb DEFAULT CHARSET=utf8 auto_increment=100 comment = '字典类型表';


insert into sys_dict_type values(1,  '用户性别', 'sys_user_sex',        '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '用户性别列表');
insert into sys_dict_type values(2,  '菜单显示状态', 'sys_show_hide',       '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '菜单状态列表');
insert into sys_dict_type values(3,  '系统开关', 'sys_on_off',  '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '系统开关列表');
insert into sys_dict_type values(4,  '定时任务状态', 'sys_job_status',      '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '任务状态列表');
insert into sys_dict_type values(5,  '系统是否', 'sys_yes_no',          '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '系统是否列表');
insert into sys_dict_type values(6,  '通知类型', 'sys_notice_type',     '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '通知类型列表');
insert into sys_dict_type values(7,  '通知状态', 'sys_notice_status',   '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '通知状态列表');
insert into sys_dict_type values(8,  '操作类型', 'sys_oper_type',       '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '操作类型列表');
insert into sys_dict_type values(9,  '系统状态', 'sys_general_status',   '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '登录状态列表');


-- ----------------------------
-- 3、字典数据表
-- ----------------------------
drop table if exists sys_dict_data;
create table sys_dict_data
(
    dict_code        bigint(20) 		 not null auto_increment    comment '字典编码',
    dict_sort        int(4)          default 0                  comment '字典排序',
    dict_label       varchar(100)    default ''                 comment '字典标签',
    dict_value       varchar(100)    default ''                 comment '字典键值',
    dict_type        varchar(100)    default ''                 comment '字典类型',
    css_class        varchar(100)    default ''                 comment '样式属性（其他样式扩展）',
    list_class       varchar(100)    default ''                 comment '表格回显样式',
    is_default       char(1)         default 'N'                comment '是否默认（Y是 N否）',
    status 			     char(1) 		 default '0'			    comment '状态（0正常 1停用）',
    create_by        varchar(64)     default ''                 comment '创建者',
    create_time      datetime   NOT NULL ON UPDATE CURRENT_TIMESTAMP comment '创建时间',
    update_by        varchar(64) 	 default ''			        comment '更新者',
    update_time      datetime                                   comment '更新时间',
    remark 	         text 				comment '备注',
    primary key (dict_code)
) engine=innodb DEFAULT CHARSET=utf8 auto_increment=100 comment = '字典数据表';


insert into sys_dict_data values(1,  1,  '男',       '0',  'sys_user_sex',        '',   '',        'Y', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '性别男');
insert into sys_dict_data values(2,  2,  '女',       '1',  'sys_user_sex',        '',   '',        'N', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '性别女');
insert into sys_dict_data values(3,  3,  '未知',     '2',  'sys_user_sex',        '',   '',        'N', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '性别未知');
insert into sys_dict_data values(4,  1,  '显示',     '0',  'sys_show_hide',       '',   'primary', 'Y', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '显示菜单');
insert into sys_dict_data values(5,  2,  '隐藏',     '1',  'sys_show_hide',       '',   'danger',  'N', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '隐藏菜单');
insert into sys_dict_data values(6,  1,  '正常',     '0',  'sys_on_off',  '',   'primary', 'Y', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '正常状态');
insert into sys_dict_data values(7,  2,  '停用',     '1',  'sys_on_off',  '',   'danger',  'N', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '停用状态');
insert into sys_dict_data values(8,  1,  '正常',     '0',  'sys_job_status',      '',   'primary', 'Y', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '正常状态');
insert into sys_dict_data values(9,  2,  '暂停',     '1',  'sys_job_status',      '',   'danger',  'N', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '停用状态');
insert into sys_dict_data values(10, 1,  '是',       'Y',  'sys_yes_no',          '',   'primary', 'Y', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '系统默认是');
insert into sys_dict_data values(11, 2,  '否',       'N',  'sys_yes_no',          '',   'danger',  'N', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '系统默认否');
insert into sys_dict_data values(12, 1,  '通知',     '1',  'sys_notice_type',     '',   'warning', 'Y', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '通知');
insert into sys_dict_data values(13, 2,  '公告',     '2',  'sys_notice_type',     '',   'success', 'N', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '公告');
insert into sys_dict_data values(14, 1,  '正常',     '0',  'sys_notice_status',   '',   'primary', 'Y', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '正常状态');
insert into sys_dict_data values(15, 2,  '关闭',     '1',  'sys_notice_status',   '',   'danger',  'N', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '关闭状态');
insert into sys_dict_data values(16, 1,  '新增',     '1',  'sys_oper_type',       '',   'info',    'N', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '新增操作');
insert into sys_dict_data values(17, 2,  '修改',     '2',  'sys_oper_type',       '',   'info',    'N', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '修改操作');
insert into sys_dict_data values(18, 3,  '删除',     '3',  'sys_oper_type',       '',   'danger',  'N', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '删除操作');
insert into sys_dict_data values(19, 4,  '授权',     '4',  'sys_oper_type',       '',   'primary', 'N', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '授权操作');
insert into sys_dict_data values(20, 5,  '导出',     '5',  'sys_oper_type',       '',   'warning', 'N', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '导出操作');
insert into sys_dict_data values(21, 6,  '导入',     '6',  'sys_oper_type',       '',   'warning', 'N', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '导入操作');
insert into sys_dict_data values(22, 7,  '强退',     '7',  'sys_oper_type',       '',   'danger',  'N', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '强退操作');
insert into sys_dict_data values(23, 8,  '生成代码', '8',  'sys_oper_type',       '',   'warning', 'N', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '生成操作');
insert into sys_dict_data values(24, 9,  '清空数据', '9',  'sys_oper_type',       '',   'danger',  'N', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '清空操作');
insert into sys_dict_data values(25, 1,  '成功',     '0',  'sys_general_status',   '',   'primary', 'N', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '正常状态');
insert into sys_dict_data values(26, 2,  '失败',     '1',  'sys_general_status',   '',   'danger',  'N', '0', 'admin', '2020-05-22 11-33-00', 'admin', '2020-05-22 11-33-00', '停用状态');

-- ----------------------------
-- 4、定时任务调度表
-- ----------------------------
drop table if exists sys_job;
create table sys_job (
                         job_id 		      bigint(20) 	    not null auto_increment    comment '任务ID',
                         job_name            varchar(64)   default ''                 comment '任务名称',
                         job_group           varchar(64)   default ''                 comment '任务组名',
                         method_name         varchar(500)  default ''                 comment '任务方法',
                         method_params       text  default null                 comment '方法参数',
                         cron_expression     varchar(255)  default ''                 comment 'cron执行表达式',
                         misfire_policy      varchar(20)   default '3'                comment '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
                         concurrent          char          default '1'                comment '是否并发执行（0允许 1禁止）',
                         status              char(1)       default '0'                comment '状态（0正常 1暂停）',
                         create_by           varchar(64)   default ''                 comment '创建者',
                         create_time         datetime    NOT NULL ON UPDATE CURRENT_TIMESTAMP  comment '创建时间',
                         update_by           varchar(64)   default ''                 comment '更新者',
                         update_time         datetime                                 comment '更新时间',
                         remark              text                 comment '备注信息',
                         primary key (job_id, job_name, job_group)
) engine=innodb auto_increment=100 comment = '定时任务调度表';

insert into sys_job values(1, 'adminTask', '系统默认（无参）', 'NoParams',  '',   '0/10 * * * * ?', '3', '1', '1', 'admin', '2018-03-16 11-33-00', 'admin', '2018-03-16 11-33-00', '');
insert into sys_job values(2, 'adminTask', '系统默认（有参）', 'Params',    'admin', '0/20 * * * * ?', '3', '1', '1',  'admin', '2018-03-16 11-33-00', 'admin', '2018-03-16 11-33-00', '');

