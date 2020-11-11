package com.znv.peim.bpm.common;

/**
 * 错误号
 * @author xkh
 */
public interface SystemMessage {
    /**
     * 业务方法
     */
    void service();

    /** Operate Successfully */
    int RET_SUCCESS = 0;
    /* -------------------- PEIM新增错误码 -------------------- */
    /** 记录不存在 */
    int ERROR_OBJECT_NOT_EXIST = -600000001;
    /** 名称已经存在 */
    int ERROR_NAME_ALREADY_EXISTS = -600000002;
    /** en_info="Exist Associated Use " zh_info="存在关联的用户"*/
    int ERROR_EXIST_ASSOCIATEDUSER = -600000007;
    /** 没有相关数据权限 */
    int ERROR_NO_DATA_RIGHT = -600000009;
    /** 未选择功能不能配用户 */
    int ERROR_NULL_ROLE_FUNCTION = -600000014;
    /** 卡号不能为空*/
    int ERROR_NULL_CARD_ID = -600000018;
    /** 帐号被禁用 */
    int ERROR_ACCOUNT_BANNED = -600000019;
    /** 帐号密码过期-超过三个月未修改密码 */
    int ERROR_PASSWORD_EXPIRED = -600000020;
    /** 告警不存在或已消除 */
    int ERROR_ALARM_NOT_EXIST = -600000029;
    /** 局站类型未配置 */
    int ERROR_STATIONTYPE_NOT_CONFIG = -600000030;
    /** 客户端节点(接入服务器)未连接 */
    int ERROR_ACCESS_NOT_CONNECT = -600000031;
    /** 发送失败（短信邮件告警测试失败） */
    int ERROR_SEND_UNSUCCESSFUL = -600000033;
    /** 预置位数小于添加的预置位数量 */
    int ERROR_CAMERA_PRESET = -600000034;
    /** 区域下没有机房/局站 */
    int ERROR_NULL_SUBPRE = -600000035;
    /** 应用失败,模板区域公式失效 */
    int ERROR_INVALID_EXPRESSION = -600000036;
    /** 应用失败,公式中的设备不属于模板区域 */
    int ERROR_DEVICE_NOT_BELONG_PRECINCT = -600000037;
    /** 应用失败,设备数量不匹配 */
    int ERROR_DEVICE_NUMBER_NO_MATCH = -600000038;
    /** 应用失败,应用区域没有监控量 */
    int ERROR_PRECINCT_NULL_METE = -600000039;
    /** 应用失败,应用区域没有用电类型 */
    int ERROR_PRECINCT_NULL_KIND = -600000040;
    /** FSU设备数量超出限制 */
    int ERROR_FSU_EXCEEDED = -600000041;
    /** en_info="The preset point already exists in the inspection list, you need to remove it from the inspection list in order to delete the preset" zh_info="该预置点已存在在巡检列表中，需从巡检列表中删除才能删除该预置点" */
    int ERROR_PRESET_EXISTVIDEOPATROLLIST = -600000042;
    /** en_info="There Is a Confict Between This Shift Time And Others " zh_info="该班次时间与已排班的班次时间产生冲突"*/
    int ERROR_SHIFT_TIME_CONFICT = -600000043;
    /** en_info="This user has been added to other workgroup" zh_info="该用户已添加到其他班组" */
    int ERROR_ADD_WORKGROUP_USER = -600000044;
    /** 系统初始化,用电量表未生成 */
    int ERROR_NO_DATATABLE = -600000045;
    /** 应用失败,设备不匹配 */
    int ERROR_DEVICE_NO_MATCH = -600000046;
    /** 维护类型已存在 */
    int ERROR_MAINTAIN_TYPE_ALREADY_EXISTS = -600000047;
    /** 存在关联的资产 */
    int ERROR_EXIST_ASSOCIATED_ASSET = -600000048;
    /** 存在子资产类型 */
    int ERROR_EXIST_SUB_ASSET_TYPE = -600000049;
    /** 上架机柜位已占用 */
    int ERROR_EXIST_CABINET_ADDRESS = -600000050;
    /** 超出额定功率 */
    int ERROR_EXCEED_CABINET_RATED_POWER = -600000051;
    /** 资产已在线 */
    int ERROR_EXIST_SHIEF_ASSET = -600000057;
    /** 机柜列空间已满 */
    int ERROR_CABINET_COLUMN_EXCEEDED = -600000058;
    /** 存在上架的资产 */
    int ERROR_EXIST_SHIEF_ASSET_INFO = -600000059;
    /** 存在关联工单过滤器 */
    int ERROR_EXIST_ORDER_FILTER = -600000061;
    /** 超出机柜U位 */
    int ERROR_EXCEED_U_HEIGHT = -600000062;
    /** 存在资产编号 */
    int ERROR_EXIST_ASSET_CODE = -600000063;
    /** 接入服务器不存在 */
    int ERROR_ACCESS_NOT_EXIST = -600000064;
    /** 模板已被使用 */
    int ERROR_EXIST_MODEL_USED = -600000065;
    /** 存在关联的巡检计划 */
    int ERROR_EXIST_PARTOL_PLAN = -600000066;
    /** 存在子节点 */
    int ERROR_EXIST_SUB_NODE = -600000067;
    /** 存在关联工单 */
    int ERROR_EXIST_ORDER = -600000068;
    /** 存在关联资产 */
    int ERROR_EXIST_ASSET = -600000069;
    /** 重复关联 */
    int ERROR_EXIST_CORRELATION = -600000070;
    /** 表达式不合法 */
    int ERROR_ILLEGAL_EXPRESSON = -600000072;
    /** 表达式存在循环 */
    int ERROR_EXIST_CYCLIC = -600000073;
    /** 设备类型错误 */
    int ERROR_DEVICE_TYPE = -600000074;
    /** 存在已创建过工单的告警 */
    int ERROR_EXIST_CREATED_ORDER_ALARM = -600000075;
    /** 设备已绑定其他资产 */
    int ERROR_BIND_OTHER_ASSET = -600000076;
    /** 已被关联的FSU */
    int ERROR_BE_RELATED_FSU = -600000077;
    /** 本点表达式不允许包含其他监控量 **/
    int ERROR_SELFONLY_EXPRESSON = -600000078;
    /** 连接FSU中断 */
    int CONNECT_FSU_INTERRUPTED = -600000095;
    /** 连接设备中断 */
    int CONNECT_DEVICE_INTERRUPTED = -600000096;
    /* -------------------- ICap新增错误码 -------------------- */

    /** 无法删除有子设备的区域；Fail To Delete Precinct Which Has Child Precinct */
    int ERROR_NO_PERMITTED_DELETE_PRECINCT = -536860001;

    /* -------------------- 以前的错误号 -------------------- */

    /** zh_info: 访问失败 ; en_info: Operate Unsuccessfully */
    int RET_FAILED = -1;

    /** zh_info: 电视墙重连成功 ; en_info: TVS reconnection successful */
    int RET_RECONNECT_SCREENWALL = 1;

    /** zh_info: PU无硬盘 ; en_info: PU NO DISK */
    int PU_NO_DISK = 768;

    /** zh_info: 空指针错误 ; en_info: Null Pointer */
    int ERROR_NULL_POINTER = -536862719;

    /** zh_info: 非法参数错误 ; en_info: Invalid Parameter */
    int ERROR_INVALID_ARGUMENT = -536862718;

    /** zh_info: 协议解析错误 ; en_info: Error in Parsing Protocol */
    int ERROR_PROTOCOL_PARSE = -536862717;

    /** zh_info: 协议不支持 ; en_info: Protocol does not support */
    int ERROR_PROTOCOL_NONSUPPORT = -536862716;

    /** zh_info: 请求视频头超时 ; en_info: Request Camera Video Overtime */
    int REQUEST_VIDEO_HEADER_TIMEOUT = -536862463;

    /** zh_info: 请求视频发送超时 ; en_info: Request Sending Video Overtime */
    int REQUEST_VIDEO_SEND_TIMEOUT = -536862462;

    /** zh_info: 请求视频路由失败 ; en_info: Fail to Request Video Rooting */
    int REQUEST_VIDEO_ROUTER_FAIL = -536862461;

    /** zh_info: 服务器获取路由错误 ; en_info: Error in Retrieving Rooting in Server */
    int REQUEST_VIDEO_ROUTER_ERROR = -536862460;

    /** zh_info: 无可用的视频路由 ; en_info: No Available Video Rooting */
    int NO_AVALIABLE_VIDEO_ROUTER = -536862459;

    /** zh_info: 视频中断 ; en_info: Video Interrupted */
    int VIDEO_DATA_INTERRUPTED = -536862458;

    /** zh_info: 正在重新连接服务器 ; en_info: ReConnecting to Server */
    int RECONNECTING_DISPATCH_SERVER = -536862457;

    /** zh_info: 媒体会话中断 ; en_info: Media Session Interrupt */
    int MEDIA_SESSION_INTERRUPT = -536862456;

    /** zh_info: 路由信息不合法 ; en_info: Route Invalid */
    int ERROR_ROUTER_VALID = -536862455;

    /** zh_info: RTP端口打开失败 ; en_info: Open RTP Port Failed */
    int ERROR_BIND_RTP_PORT = -536862454;

    /** zh_info: 创建请求信息失败 ; en_info: Create Invite Failed */
    int ERROR_CREATE_REQUEST = -536862453;

    /** zh_info: 存储服务器未接收到数据 ; en_info: Store Not Recv Data */
    int ERROR_STORE_NORECV = -536862452;

    /** zh_info: 不支持的编码设备类型 ; en_info: Unsupported Encoder Type */
    int UNSUPPORTED_ENCODER_TYPE = -536862448;

    /** zh_info: 不支持的视频传输方式 ; en_info: Unsupported Video Transmission Mode */
    int UNSUPPORTED_VIDEO_LINK_MODEL = -536862447;

    /** zh_info: 设备未注册 ; en_info: Pu not register */
    int PU_NOT_REGISTER = -536862446;

    /** zh_info: 前端PU请求出错 ; en_info: PU Request Error */
    int PU_REQUEST_FAULT = -536862445;

    /** zh_info: 前端PU语音通道已占用 ; en_info: Pu audio channels have been occupied */
    int PU_AUDIO_CHANNEL_USED = -536862444;

    /** zh_info: 登录PU失败 ; en_info: PU Login Error */
    int PU_LOGIN_FAIL = -536862443;

    /** zh_info: 参数获取失败 ; en_info: Parameter acquisition fails */
    int PARAM_GET_FAIL = -536862442;

    /** zh_info: 不支持型号 ; en_info: Model is not supported */
    int NOT_SUPPORTED_MODEL = -536862441;

    /** zh_info: SDK调用失败 ; en_info: SDK call fails */
    int SDK_CALL_FAIL = -536862440;

    /** zh_info: 前端设备用户名密码错误 ; en_info: Invalid UserName or PSWD for PU */
    int PU_PASSWORD_ERROR = -536862439;

    /** zh_info: 访问前端设备权限不足 ; en_info: No Enough Right for PU */
    int PU_NO_ENOUGH_RIGHT = -536862438;

    /** zh_info: PU未初始化 ; en_info: PU Not Initialize */
    int PU_NOT_INIT = -536862437;

    /** zh_info: 通道号错误 ; en_info: PU Channel Error */
    int PU_CHANNEL_ERROR = -536862436;

    /** zh_info: 登录PU用户数达到最大 ; en_info: PU Over Max Link */
    int PU_OVER_MAXLINK = -536862435;

    /** zh_info: 版本不匹配 ; en_info: PU Version Not Match */
    int PU_VERSION_NOMATCH = -536862434;

    /** zh_info: 连接编码器设备 ; en_info: Connect PU Failed */
    int PU_CONNECT_FAIL = -536862432;

    /** zh_info: 向编码器发送失败 ; en_info: PU Send Error */
    int PU_SEND_ERROR = -536862431;

    /** zh_info: 从编码器接收失败 ; en_info: PU Receive Error */
    int PU_RECV_ERROR = -536862430;

    /** zh_info: 编码器忙 ; en_info: PU Is Busy */
    int PU_BUSY = -536862429;

    /** zh_info: 视频连接个数达到最大 ; en_info: PU Over Max Video Link */
    int PU_OVER_MAX_VIDEOLINK = -536862428;

    /** zh_info: 被模拟量告警配置使用，不能删除 ; en_info: be used by ai alarm config ,can not delete */
    int ERROR_USED_BY_CONFIG = -536862427;

    /** zh_info: 被模拟量场景使用，不能删除 ; en_info: be used by scene,can not delete */
    int ERROR_USED_BY_SCENE = -536862426;

    /** zh_info: 该存储服务器未配置 ; en_info: The storage server is not configured */
    int ERROR_STORE_NOT_CONFIG = -536862425;

    /** zh_info: 存储服务器不能备份本机的录像文件 ; en_info: Storage server can not back up the video files */
    int ERROR_STORE_NOT_BAKUP = -536862424;

    /** zh_info: 视频带宽限制 ; en_info: Video bandwidth limit */
    int ERROR_VIDEO_BANDWIDTH_LIMIT = -536862423;

    /** zh_info: 连接未找到 ; en_info: Connection Not Found */
    int ERROR_NOT_FOUND_LONG_CONNECT = -536862208;

    /** zh_info: 开始建立连接的时候发生失败 ; en_info: Error in Starting to Build Connection */
    int ERROR_CONNECT_FAILURE_BEGIN = -536862207;

    /**
     * zh_info: 在I/O流上发起异步读写操作时失败，导致连接失败 ; en_info: Fail to Connect Due to Failure to Start Asynchronous Reading and
     * Writing Operations in I/O Streams
     */
    int ERROR_CONNECT_FAILURE_IO_STREAM = -536862206;

    /** zh_info: 正在建立长连接 ; en_info: Building Long Connection */
    int ERROR_NOW_LONG_CONNECT = -536862205;

    /** zh_info: 连接服务器失败 ; en_info: Fail to Connect to Server */
    int CONNECT_SERVER_FAIL = -536862192;

    /** zh_info: 请求超时 ; en_info: Request Overtime */
    int REQUEST_TIME_OUT = -536862191;

    /** zh_info: 连接服务器中断 ; en_info: Connection to Server Interrupted */
    int ERROR_SERVER_INTERRUPT = -536862190;

    /** zh_info: 客户端重连后登录失败 ; en_info: Fail to Login after ReConnection */
    int ERROR_CLIENT_LOGIN = -536862189;

    /** zh_info: 客户端重连后登录超时 ; en_info: Login Overtime after ReConnection */
    int ERROR_RELOGIN_TIMEOUT = -536862188;

    /** zh_info: 电视墙业务服务器连接中断 ; en_info: TVS connection interrupted */
    int ERROR_SCREENWALL_SERVER_INTERRUPT = -536862187;

    /** zh_info: 服务器未连接 ; en_info: Server not connect */
    int ERROR_SERVER_NOT_CONNECT = -536862186;

    /** zh_info: 数据发送缓冲区满 ; en_info: Send data buffer is full */
    int ERROR_SEND_BUFFER_FULL = -536862176;

    /** zh_info: UDP消息大小错误 ; en_info: UDP message size error */
    int ERROR_MSG_SIZE = -536862175;

    /** zh_info: 错误的组播地址 ; en_info: Multicast address is wrong */
    int ERROR_MULTICAST_ADDRESS = -536862174;

    /** zh_info: rtp socket已打开 ; en_info: rtp socket is open */
    int ERROR_RTP_SOCK_OPENED = -536862173;

    /** zh_info: 错误的RTP端口号 ; en_info: The wrong RTP port number */
    int ERROR_RTP_PORT = -536862172;

    /** zh_info: 错误的目标地址 ; en_info: The target address is wrong */
    int ERROR_UNICAST_ADDRESS = -536862171;

    /** zh_info: 目的不可到达 ; en_info: Destination UnReached */
    int ERROR_UNREACHED = -536862170;

    /** zh_info: 访问数据库失败 ; en_info: Fail to Access Database */
    int ERROR_ACCESS_DATABASE = -536861951;

    /** zh_info: 未找到记录 ; en_info: Find No Record */
    int ERROR_NO_RECORD = -536861950;

    /** zh_info: 数据库存在该数据或相关数据 ; en_info: Specified Data or Related Data Exist in Database */
    int ERROR_KEY_CONFLICT = -536861949;

    /** zh_info: 数据库紧急阈值和普通阈值设置错误 ; en_info: The emergency database threshold and the normal threshold setting error */
    int ERROR_THRESHOLD_SET = -536861948;

    /** zh_info: 服务器已登录 ; en_info: Server Already Login */
    int ERROR_SERVER_LOGINED = -536861947;
    
    /** zh_info: ID冲突 ; en_info: ID Conflict */
    int ERROR_ID_CONFLICT = -536861945;

    /** zh_info: 用户已停用 ; en_info: The User Has Been Deactivated */
    int ERROR_USER_SUSPEND = -536861936;

    /** zh_info: 没有执行操作的权限 ; en_info: No Right to Operate */
    int ERROR_NO_AUTHORITY = -536861935;

    /** zh_info: 用户不存在 ; en_info: The User Does Not Exist */
    int ERROR_NO_USER = -536861934;

    /** zh_info: 密码错误 ; en_info: Wrong Password */
    int ERROR_INVALID_PWD = -536861933;

    /** zh_info: 同时登录用户数已达到最大 ; en_info: Reaching Upper Limit of Simultaneous Online */
    int ERROR_MAX_LOGINED = -536861932;

    /** zh_info: 会话ID重复 ; en_info: Repeated Session ID */
    int ERROR_SESSION_EXIST = -536861931;

    /** zh_info: 空session id错误 ; en_info: Null Session ID */
    int ERROR_SESSION_NULL = -536861930;

    /** zh_info: 无可用的用户信息 ; en_info: No Available User Information */
    int ERROR_USERINFO_NULL = -536861929;

    /** zh_info: 客户端已经有用户登录 ; en_info: The User Already Login in Client */
    int ERROR_USER_LOGINING = -536861928;

    /** zh_info: 大客户登录用户数达到最大 ; en_info: Reach Upper Limit of Administrator's User Count */
    int ERROR_MAX_GROUP_LOGIN = -536861927;

    /** zh_info: 用户名重复 ; en_info: Repeated User Name */
    int ERROR_USER_NAME_REPEATED = -536861920;

    /** zh_info: 用户数已达到最大 ; en_info: Reach Upper Limit of User Count */
    int ERROR_MAX_USER_COUNT = -536861919;

    /** zh_info: 用户组名称重复 ; en_info: Repeated User Group Name */
    int ERROR_GROUP_NAME_REPEQTED = -536861918;

    /** zh_info: 用户需要MAC绑定 ; en_info: User Account Should Be Bounded with MAC Address */
    int ERROR_NEED_MAC_BOUND = -536861917;

    /** zh_info: 用户需要USB KEY绑定 ; en_info: User Account Should Be Bounded with USB Key */
    int ERROR_NEED_USBKEY_BOUND = -536861916;

    /** zh_info: 客户端类型未授权 ; en_info: Client Not Authorized */
    int ERROR_CLIENT_FAULT = -536861915;

    /** zh_info: 名字重复 ; en_info: name repeat */
    int ERROR_NAME_REPEATED = -536861914;

    /** zh_info: 大客户前缀重复 ; en_info: Repeated Administrator Prefix */
    int ERROR_ENTERPRISE_PREFIX_REPEATED = -536861913;

    /** zh_info: 大客户名称重复 ; en_info: Repeated Administrator Name */
    int ERROR_ENTERPRISE_NAME_REPEATED = -536861912;

    /** zh_info: 大客户已经有管理员 ; en_info: The Administrator Has A Manager Already */
    int ERROR_ENTERPRISE_ADMIN_EXIST = -536861911;

    /** zh_info: 服务器验证失败 ; en_info: Fail to Pass Authentication */
    int ERROR_MAC_VALIDATE = -536861903;

    /** zh_info: 服务器验证失败 ; en_info: Fail to Pass Authentication */
    int ERROR_USBKEY_VALIDATE = -536861902;

    /** zh_info: 服务器验证失败 ; en_info: Fail to Pass Authentication */
    int ERROR_MAC_USBKEY_VALIDATE = -536861901;

    /** zh_info: 客户端提供的USB Key已经被绑定 ; en_info: USB Key Provided by Client Has Been Bounded */
    int ERROR_USBKEY_HAVE_BOUND = -536861900;

    /** zh_info: 存储路数已达预警值 ; en_info: Store Camera Number Alarm */
    int ERROR_STORE_NUM_LIMIT_PRE = -536861899;

    /** zh_info: 存储服务器路数配置已满 ; en_info: Store Is Full, Can't Add Camera */
    int ERROR_STORE_NUM_LIMIT = -536861898;

    /** zh_info: 存储服务器空间已达预警值 ; en_info: Store Space Alarm */
    int ERROR_STORE_SPACE_LIMIT_PRE = -536861897;

    /** zh_info: 存储服务器空间已满，不能添加摄像头 ; en_info: Store Is No Space,Can't Add Camera */
    int ERROR_STORE_SPACE_LIMIT = -536861896;

    /** zh_info: 超过上传时间段 ; en_info: Over Download Duration */
    int ERROR_OVER_DOWNLOAD_DURATION = -536861895;

    /** zh_info: 局站下面有子局站，不能删除 ; en_info: Fail To Delete Office Which Has Child Office */
    int ERROR_HAVE_CHILD_OFFICE = -536861888;

    /** zh_info: 局站重名 ; en_info: Repeated Office Name */
    int ERROR_OFFICE_NAME_REPEATED = -536861887;

    /** zh_info: 编码器和路数重复 ; en_info: Repeated Encoder Name or Channels */
    int ERROR_ENCODER_PORT_REPEATED = -536861886;

    /** zh_info: 设备已停用 ; en_info: The Device Has Been Deactivated */
    int ERROR_DEVICE_STOPPED = -536861885;

    /** zh_info: 服务器正在使用不能被删除 ; en_info: server using,can't be delete */
    int ERROR_SERVER_INUSE = -536861884;

    /** zh_info: 注册服务器不匹配 ; en_info: register server not match */
    int ERROR_REG_SERVER_NOT_MATCH = -536861883;

    /** zh_info: 用户存在已创建的组，不能删除 ; en_info: User Have Group */
    int ERROR_USER_HAVE_GROUP = -536861882;

    /** zh_info: 创建摄像头数达到最大 ; en_info: create camear max count */
    int ERROR_MAX_CAMERA_COUNT = -536861881;

    /** zh_info: 域名错误 ; en_info: Domain Name error */
    int ERROR_INVALID_DOMAIN = -536861880;

    /** zh_info: 省名称已存在 ; en_info: Province Name Already Exist */
    int ERROR_PROVINCE_NAME_EXIST = -536861872;

    /** zh_info: 创建省数量达到最大值100 ; en_info: Province Count Reach Maximum 100 */
    int ERROR_PROVINCE_FULL = -536861871;

    /** zh_info: 省下有市不能删除 ; en_info: Fail To Delete Province Which Have Cites */
    int ERROR_PROVINCE_HAVE_CITY = -536861870;

    /** zh_info: 省下有局站不能删除 ; en_info: Fail To Delete Province Which Have Offices */
    int ERROR_PROVINCE_HAVE_OFFICE = -536861869;

    /** zh_info: 市名称已存在 ; en_info: City Name Already Exist */
    int ERROR_CITY_NAME_EXIST = -536861868;

    /** zh_info: 创建市数量达到最大值100 ; en_info: City Count Reach Maximum 100 */
    int ERROR_CITY_FULL = -536861867;

    /** zh_info: 市下有局站不能删除 ; en_info: Fail To Delete City Which Have Offices */
    int ERROR_CITY_HAVE_OFFICE = -536861866;

    /** zh_info: 5000设备的IP地址已存在 ; en_info: 5000 SDK PU IP Exist */
    int ERROR_5000PU_IP_EXIST = -536861865;

    /** zh_info: 数据库只能添加一个，目前已经存在 ; en_info: Database has Existed */
    int ERROR_DATABASE_IS_EXIST = -536861864;

    /** zh_info: 业务号重复 ; en_info: Bussiness number repeated */
    int ERROR_BUSINESS_NUMBER_REPEATED = -536861863;

    /** zh_info: 系统中已经存在一个中心服务器 ; en_info: CMS has Existed */
    int ERROR_DATABASE_CMS_EXIST = -536861862;

    /** zh_info: 客户端版本太旧，请升级新版本 ; en_info: Client Version is too old */
    int ERROR_OLDVERSION_CANNOT_USED = -536861861;

    /** zh_info: 没有添加手动巡航任务 ; en_info: not find manual camera cruise task */
    int ERROR_NO_MANUAL_CRUISE_RECORD = -536861860;

    /** zh_info: 摄像头设置为不存储 ; en_info: camera store is not record */
    int ERROR_NO_STORE_TYPE = -536861859;

    /** zh_info: 摄像头未配置存储服务器 ; en_info: camera no store server */
    int ERROR_NO_SET_STORE = -536861858;

    /** zh_info: 缓冲区不足 ; en_info: Buffer Not Enough */
    int ERROR_BUFFER_NOT_ENOUGH = -536861695;

    /** zh_info: 会话没有初始化 ; en_info: Session Not Initialized */
    int ERROR_SESSION_NOT_INIT = -536861664;

    /** zh_info: 访问USB Key发生错误 ; en_info: Error in Accessing USB Key */
    int ERROR_ACCESS_UKEY = -536861648;

    /** zh_info: 没有插入USB Key ; en_info: USB Key Not Found */
    int ERROR_NO_UKEY = -536861647;

    /** zh_info: 数据库没有设置锁定次数初始记录 ; en_info: Allowable Times before Being Locked Not Been Initialized in Database */
    int ERROR_NO_USERLOCKCOUNT = -536861615;

    /** zh_info: 数据库没有设置锁定时间初始记录 ; en_info: Locking Time Not Been Initialized in Database */
    int ERROR_NO_USERLOCKTIME = -536861614;

    /** zh_info: 用户被锁定 ; en_info: The User Has Been Locked */
    int ERROR_USERLOCK = -536861613;

    /** zh_info: 用户IP被锁定 ; en_info: The User IP Has Been Locked */
    int ERROR_MACLOCK = -536861610;

    /** zh_info: 服务器错误 ; en_info: Error in Server */
    int ERROR_SERVER_FAULT = -536861440;

    /** zh_info: 服务器命令缓冲区满 ; en_info: Server Command Buffer is Full */
    int ERROR_COMMAND_BUFFER_FULL = -536861439;

    /** zh_info: 内存不足 ; en_info: Out of Memory */
    int ERROR_OUT_OF_MEMORY = -536861438;

    /** zh_info: 该平台不支持此功能 ; en_info: function not support */
    int ERROR_SERVER_NOT_SUPPORT = -536861437;

    /** zh_info: 告警已确认 ; en_info: Alarm confirmed */
    int ERROR_ALARM_CONFIRMED = -536861436;

    /** zh_info: 设备未找到 ; en_info: Device not found */
    int ERROR_DEVICE_NOT_FOUND = -536861435;

    /** zh_info: 设置状态未知 ; en_info: Device state unknown */
    int ERROR_DEV_STATE_UNKNOWN = -536861434;

    /** zh_info: 服务器端session超时 ; en_info: Overtime Session in Server */
    int ERROR_SESSION_TIMEOUT = -536861424;

    /** zh_info: 设备不在线 ; en_info: Device Offline */
    int ERROR_PU_OFFLINE = -536861408;

    /** zh_info: 解码器不在线 ; en_info: Decoder offline */
    int ERROR_DECODER_OFFLINE = -536861407;

    /** zh_info: 服务器ID不存在或者服务器类型不匹配 ; en_info: server ID not exist or server type not match */
    int ERROR_SERVER_NOT_MATCH = -536861405;

    /** zh_info: 前端PU不支持 ; en_info: Not Supported by PU */
    int ERROR_PU_NOT_SUPPORT_PROTOCOL = -536861183;

    /** zh_info: PU忙，请稍后再试 ; en_info: PU is Busy, Please Try Later */
    int DVR_BUSY = -536861182;

    /** zh_info: 5000设备不可用 ; en_info: 5000SDK device can't use */
    int ERROR_SDKPU_CANNOTUSE = -536861181;

    /** zh_info: 非法操作，子局站设置的权限大于父局站的权限 ; en_info: child office privilege overtake the parent */
    int ERROR_CHILDOFFICE_OVERTAKE_PARENT = -536860400;

    /** zh_info: 用户没有参加会议的权限 ; en_info: user has no authority to attend meeting */
    int NO_AUTHORITY_TO_ATTEND_MEETING = -536860384;

    /** zh_info: 该PU类型拥有的摄像头数达到最大，创建摄像头失败 ; en_info: Putype has max camera number,fail to add camera */
    int ERROR_PUTYPE_MAX_CAMERA_COUNT = -536860367;

    /** zh_info: 该会议室在使用中，不能编辑 ; en_info: Meeting room is in use,can not edit */
    int MEETINGROOM_IN_USE = -536860383;

    /** zh_info: 视频资源达到极限 ; en_info: video resource limited */
    int ERROR_VIDEO_RESOURCE_LIMITED = -536860366;

    /** zh_info: 用户拥有其他局站设备权限，不允许更改局站 ; en_info: user can't change office */
    int ERROR_USER_CANNOT_CHANGE_OFFICE = -536860365;

    /** zh_info: 厂家未授权或厂家设备数达到最大 ; en_info: factory no authoraze or max factory device num */
    int ERROR_MAX_FACTORY_DEVICE_LIMITED = -536860364;

    /** zh_info: 转码模板配置已经存在 ; en_info: TransCode Config Has Existed */
    int ERROR_TRANSCODE_TEMPLET_EXIST = -536860363;

    /** zh_info: 该接入服务器已超出能力限制，请选择其他接入服务器 ; en_info: The Server Is Limited, Please Change Others */
    int ERROR_CSG_LIMIT = -536860362;

    /** zh_info: 该转发服务器已超出能力限制，请选择其他转发服务器 ; en_info: The Server Is Limited, Please Change Others */
    int ERROR_MDU_LIMIT = -536860361;

    /** zh_info: 该存储服务器已超出能力限制，请选择其他存储服务器 ; en_info: The Server Is Limited, Please Change Others */
    int ERROR_STORE_LIMIT = -536860360;

    /** zh_info: 该电视墙服务器已超出能力限制，请选择其他电视墙服务器 ; en_info: The Server Is Limited, Please Change Others */
    int ERROR_TVS_LIMIT = -536860359;

    /** zh_info: 该移动视频服务器已超出能力限制，请选择其他移动视频服务器 ; en_info: The Server Is Limited, Please Change Others */
    int ERROR_VAU_LIMIT = -536860358;

    /** zh_info: 该转码服务器已超出能力限制，请选择其他转码服务器 ; en_info: The Server Is Limited, Please Change Others */
    int ERROR_TRANSCODE_LIMIT = -536860357;

    /** zh_info: 媒体转发服务器不在线，无法申请视频 ; en_info: The Dispatch Server Is Offline */
    int ERROR_DISPATCH_OFFLINE = -536860350;

    /** zh_info: 存储服务器不在线，无法查看录像 ; en_info: The Store Server Is Offline */
    int ERROR_STORE_OFFLINE = -536860349;

    /** zh_info: 大客户不是ADC用户，不允许设置 ; en_info: The Custom Is Not ADC User */
    int ERROR_ADC_CUSTOM_NOT_EXIST = -536860348;

    /** zh_info: 自动选择转发服务器失败 ; en_info: choose dispatch server automatically failure */
    int FAILED_CHOOSE_DISPATCH_AUTO = -536860347;

    /** zh_info: 编码器模板已关联编码器，不能删除 ; en_info: Encoder mode has link encoders,can not be deleted */
    int ERROR_ENCODERMODE_HAS_ENCODER = -536860346;

    /** zh_info: 手机采集编码器用户名不能重复 ; en_info: Mobile phone encoder username can not be repeated */
    int ERROR_MOBILEPU_USERNAME_NOT_REPEAT = -536860345;

    /** zh_info: 该设备已从属于别的服务器 ; en_info: The device has to belong to another server */
    int ERROR_DEVICE_BELONG_TO_OTHER_GROUP = -536860344;

    /** zh_info: 目标对讲用户不在线 ; en_info: Talking user is offline */
    int ERROR_TALK_USER_OFFLINE = -536860343;

    /** zh_info: 目标对讲用户拒绝 ; en_info: Talking user refuse to talk */
    int ERROR_TALK_USER_REFUSE = -536860342;

    /** zh_info: 目标对讲用户占线 ; en_info: Talking user is busy */
    int ERROR_TALK_USER_BUSY = -536860341;

    /** zh_info: 录像文件不存在 ; en_info: Record File Is Not Exist */
    int ERROR_RECORD_FILE_NO_EXIST = -536861406;

    /** zh_info: 参数错误 ; en_info: parameter error */
    int ERROR_PARAMETER_ERROR = -536853760;

    /** zh_info: 局站不存在 ; en_info: station does not exist */
    int ERROR_STATION_NOT_EXIST = -536853759;

    /** zh_info: 卡口至少要配置一个车道 ; en_info: traffic sentry has no lane */
    int ERROR_TRAFFIC_SENTRY_NO_CLANE = -536853758;

    /** zh_info: 卡口业务服务器配置错误 ; en_info: traffic sentry server configure error */
    int ERROR_TRAFFIC_SENTRY_SERVER_CONFIGURE = -536853757;

    /** zh_info: 系统错误，卡口ID创建失败 ; en_info: create traffic sentry ID failed */
    int ERROR_SYSTEM_CREATE_ID_FAILED = -536853756;

    /** zh_info: 卡口不存在 ; en_info: traffic sentry not exist */
    int ERROR_TRAFFIC_SENTRY_NOT_EXIST = -536853755;

    /** zh_info: 卡口车道不存在 ; en_info: traffic lane not exist */
    int ERROR_TRAFFIC_LANE_NOT_EXIST = -536853754;

    /** zh_info: 卡口设备类型不存在 ; en_info: traffic sentry device kind not exist */
    int ERROR_TRAFFIC_SENTRY_KIND_NOT_EXIST = -536853753;

    /** zh_info: 车道对应相机信息不全 ; en_info: traffic sentry camera not complete */
    int ERROR_TRAFFIC_LANE_CAMERA_NOT_COMPLETE = -536853752;

    /** zh_info: 同一卡口设备相机分属于不同卡口 ; en_info: camera belong to different traffic sentry */
    int ERROR_CAMERA_BELONG_DIFFERENT_TRAFFIC_SENTRY = -536853751;

    /** zh_info: 同一卡口设备信息不一致 ; en_info: traffic sentry information inconsistent */
    int ERROR_TRAFFIC_SENTRY_INFORMATION_INCONSISTENT = -536853750;

    /** zh_info: 车道相机重复 ; en_info: traffic sentry camera repeat */
    int ERROR_TRAFFIC_LANE_CAMERA_REPEAT = -536853749;

    /** zh_info: 视频设备不存在 ; en_info: video equipment not exist */
    int ERROR_VIDEO_EQUIPMENT_NOT_EXIST = -536853748;

    /** zh_info: 卡口关联的接入服务器不存在 ; en_info: service of traffic sentry not eixst */
    int ERROR_SERVICE_OF_SENTRY_NOT_EXIST = -536853747;

    /** zh_info: 车道未被订阅 ; en_info: traffic sentry lane not been subscribed */
    int ERROR_SENTRY_LANE_NOT_SUBSCRIBED = -536853746;

    /** zh_info: 车道未绑定设备 ; en_info: traffic sentry lane not bind to device */
    int ERROR_SENTRYLANE_NOT_BINDDEVICE = -536853745;

    /** zh_info: 卡口设备断线 ; en_info: traffic sentry device interrupt */
    int ERROR_SENTRYLANE_DEVICE_INTERRUPT = -536853744;

    /** zh_info: 卡口图片保存失败 ; en_info: traffic sentry picture save failed */
    int ERROR_TRAFFIC_CENTRY_PICTURE_SAVE = -536853742;

    /** zh_info: 测速区间不存在 ; en_info: traffic region not exist */
    int ERROR_TRAREGION_NOTEXIST = -536853741;

    /** zh_info: 测速区间启用中,不允许修改 ; en_info: traffic region not allow to modify */
    int ERROR_TRAREGION_NOTMODIFY_WHENUSED = -536853740;

    /** zh_info: 测速区间启用中,不允许删除 ; en_info: traffic region not allow to delete */
    int ERROR_TRAREGION_NOTDEL_WHENUSED = -536853739;

    /** zh_info: 数据错误,测速区间启用失败 ; en_info: data error and traffic region start failed */
    int ERROR_STARTFAIL_DATAERROR = -536853738;

    /** zh_info: 起始卡口与终点卡口相同,测速区间启用失败 ; en_info: traffic region begin and end is the same */
    int ERROR_STARTFAIL_BEGINEND_SAME = -536853737;

    /** zh_info: 起始卡口不存在,测速区间启用失败 ; en_info: traffic region at begin not exist */
    int ERROR_STARTFAIL_BEGIN_NOTEXIST = -536853736;

    /** zh_info: 终点卡口不存在,测速区间启用失败 ; en_info: traffic region at end not exist */
    int ERROR_STARTFAIL_END_NOTEXIST = -536853735;

    /** zh_info: 起始卡口与终点卡口服务器不一致,测速区间启用失败 ; en_info: traffic regions at different sevices */
    int ERROR_STARTFAIL_NOTSAMESERVICE = -536853734;

    /** zh_info: 车牌布控时间段重叠 ; en_info: plate rule time repeat */
    int ERROR_PLATERULETIME_REPEAT = -536853733;

    /** zh_info: 测速区间重复 ; en_info: speed region repeat */
    int ERROR_SPEEDREGION_REPEAT = -536853732;

    /** zh_info: 测速区间名称重复 ; en_info: speed region name repeat */
    int ERROR_SPEEDREGION_NAME_REPEAT = -536853731;

    /** zh_info: 数据字典重复 ; en_info: data dictionary repeat */
    int ERROR_DATADICTIONARY_REPEAT = -536853730;

    /** zh_info: 数据字典信息不存在 ; en_info: data dictionary not exist */
    int ERROR_DATADICTIONARY_NOTEXIST = -536853729;

    /** zh_info: ftp信息不存在 ; en_info: ftp info not exist */
    int ERROR_FTPINFO_NOTEXIST = -536853728;

    /** zh_info: ftp名称重复 ; en_info: ftp name repeat */
    int ERROR_FTPNAME_REPEAT = -536853727;

    /** zh_info: ftp ip地址端口重复 ; en_info: ftp ip port repeat */
    int ERROR_FTPIPPORT_REPEAT = -536853726;

    /** zh_info: 卡口ID重复 ; en_info: trasentry id repeat */
    int ERROR_TRASENTRYID_REPEAT = -536853725;

    /** zh_info: 请求消息中参数不合法 ; en_info: invalid parameters in request */
    int ERROR_ARGUMENT_INVALID = -536861071;

    /** zh_info: 指定服务不存在 ; en_info: service does not exist */
    int ERROR_NO_SERVICE = -536861070;

    /** zh_info: 指定的输出通道号不存在 ; en_info: output channel does not exist */
    int ERROR_NO_OUTPUT_CHANNEL = -536861069;

    /** zh_info: 指定的划分通道号不存在 ; en_info: area channel does not exist */
    int ERROR_NO_AREA_CHANNEL = -536861068;

    /** zh_info: PU 不支持rtsp请求 ; en_info: pu does not support rtsp request */
    int ERROR_PU_NO_SUPPORT_RTSP = -536861067;

    /** zh_info: 媒体传输方式不支持 ; en_info: link mode is not supported */
    int ERROR_NO_SUPPORT_LINKMODE = -536861066;

    /** zh_info: PUID或通道不存在 ; en_info: PUID or channel does not exist */
    int ERROR_PUID_CHANNEL_NO_EXIST = -536861065;

    /** zh_info: 不支持的码流 ; en_info: streamtype is not supported */
    int ERROR_NO_SUPPORT_STREAMTYPE = -536861064;

    /** zh_info: 不支持的控制命令 ; en_info: control command is not supported */
    int ERROR_NO_SUPPORT_COMMAND = -536861063;

    /** zh_info: 文件回放不支持 ; en_info: file playback is not supported */
    int ERROR_NO_SUPPORT_FILE_PLAYBACK = -536861062;

    /** zh_info: 视频分辨率错误 ; en_info: YUV resolution does not match */
    int ERROR_YUV_RESOLUTION_NOT_MATCH = -536861061;

    /** zh_info: 超出解码能力 ; en_info: out of decode card ability */
    int ERROR_OUT_OF_DECODER_ABILITY = -536861060;

    /** zh_info: 不支持多划分或指定的划分数不支持 ; en_info: split channel or split number is not supported */
    int ERROR_NO_SUPPORT_SPLIT = -536861059;

    /** zh_info: 指定的输出通道未使能 ; en_info: output channel is unable */
    int ERROR_OUTPUT_CHANNEL_UNABLE = -536861058;

    /** zh_info: 超出最大划分数 ; en_info: greater than the max split number */
    int ERROR_OUT_OF_MAX_SPLIT = -536861056;

    /** zh_info: 摄像头未配置智能对接服务器 ; en_info: camera ia server not config */
    int ERROR_IASERVER_NOT_CONFIG = -536860320;

    /** zh_info: 分析系统错误1：初始化失败 ; en_info: ia sys error 1:init fail */
    int ERROR_IA_INITERR = -536860319;

    /** zh_info: 分析系统错误2：IASERV未启动监听 ; en_info: ia sys error 2:iaserv not listen */
    int ERROR_IA_UNINIT = -536860318;

    /** zh_info: 分析系统错误3：监听端口失败 ; en_info: ia sys error 3:listen fail */
    int ERROR_IA_LISTEN = -536860317;

    /** zh_info: 分析系统错误4：指针为空 ; en_info: ia sys error 4:null pointer */
    int ERROR_IA_NULLPOINTER = -536860316;

    /** zh_info: 分析系统错误5：没有可用的IAServ ; en_info: ia sys error 5:no available iaserv */
    int ERROR_IA_NO_IAS = -536860315;

    /** zh_info: 分析系统错误6：没有可用的IAUnit ; en_info: ia sys error 6:no avaliable iaunit */
    int ERROR_IA_NO_IAU = -536860314;

    /** zh_info: 分析系统错误7：命令超时 ; en_info: ia sys error 7:command timeout */
    int ERROR_IA_TIMEOUT = -536860313;

    /** zh_info: 分析系统错误8：发送命令失败 ; en_info: ia sys error 8:send command fail */
    int ERROR_IA_SENDERROR = -536860312;

    /** zh_info: 分析系统错误9：不支持的接口 ; en_info: ia sys error 9:unsupport interface */
    int ERROR_IA_UNSUPPORT = -536860311;

    /** zh_info: 分析系统错误10：超出分析能力限制 ; en_info: ia sys error 10:exceed analyze ability */
    int ERROR_IA_OUTOF_ABILITY = -536860310;

    /** zh_info: 分析系统错误11：不支持的设备类型 ; en_info: ia sys error 11:unsupport device type */
    int ERROR_IA_DEV_UNSUPPORT = -536860309;

    /** zh_info: 分析系统错误12：登录视频设备失败 ; en_info: ia sys error 12:login video system fail */
    int ERROR_IA_DEV_LOGIN_FAIL = -536860308;

    /** zh_info: 分析系统错误13：视频获取失败 ; en_info: ia sys error 13:request video fail */
    int ERROR_IA_DEV_VIDEO_FAIL = -536860307;

    /** zh_info: 分析系统错误14：存储服务器断开 ; en_info: ia sys error 14:store server disconnect */
    int ERROR_IA_DEV_STORAGE_FAIL = -536860306;

    /** zh_info: 分析系统错误15：启动任务不正确 ; en_info: ia sys error 15:task run incorrect */
    int ERROR_IA_TASK_START_FAIL = -536860305;

    /** zh_info: 分析系统错误16：文件打开失败 ; en_info: ia sys error 16:file open fail */
    int ERROR_IA_FILE_OPENFILE_FAIL = -536860304;

    /** zh_info: 分析系统错误17：分析结果文件上传失败 ; en_info: ia sys error 17:analyze result report fail */
    int ERROR_IA_FILE_UPLOAD_FAIL = -536860303;

    /** zh_info: 分析系统错误18：算法获取失败,不支持的算法类型 ; en_info: ia sys error 18:get algorithm fail */
    int ERROR_IA_ALG_GET_FAIL = -536860302;

    /** zh_info: 分析系统错误19：算法初始化失败 ; en_info: ia sys error 19:algorithm init fail */
    int ERROR_IA_ALG_INIT_FAIL = -536860301;

    /** zh_info: 分析系统错误20：算法参数设置失败 ; en_info: ia sys error 20:algorithm parameter config fail */
    int ERROR_IA_ALG_CONFIG_FAIL = -536860300;

    /** zh_info: 分析系统错误21：任务ID为0或未初始化 ; en_info: ia sys error 21:task id not init */
    int ERROR_IA_TASK_ID_ERROR = -536860299;

    /** zh_info: 分析系统错误22：输入缓冲太小 ; en_info: ia sys error 22:input buffer not enough */
    int ERROR_IA_BUFFER_TOO_SMALL = -536860298;

    /** zh_info: 分析系统错误24：找不到此ID的IAUnit ; en_info: ia sys error 24:find iaunit id fail */
    int ERROR_IA_IAU_ID_ERROR = -536860296;

    /** zh_info: 配置的分析单元不在线 ; en_info: the iaunit is offline */
    int ERROR_IAUNIT_OFFLINE = -536860295;

    /**
     * zh_info: 智能对接服务器存在分析任务，不能切换 ; en_info: can not change the iaunit for this camera, because there are analysis
     * tasks running
     */
    int ERROR_IAUNIT_HAS_IATASK = -536860297;

    /** zh_info: 任务正在执行 ; en_info: task is running */
    int ERROR_TASK_RUNNING = -536858368;

    /** zh_info: 任务摄像头数为零 ; en_info: task camera count is zero */
    int ERROR_TASK_NO_CAMERA = -536858367;

    /** zh_info: 无可用的分析单元 ; en_info: no available analyzer */
    int ERROR_NOAVAILABLE_ANALYZER = -536858366;

    /** zh_info: 未找到任务 ; en_info: find task fail */
    int ERROR_FIND_TASK_FAIL = -536858365;

    /** zh_info: 默认分析单元不能删除 ; en_info: unbable to delete default analyzer */
    int ERROR_CANNOTDEL_DEFAULTANALYZER = -536858364;

    /** zh_info: 默认分析单元不能修改 ; en_info: unable to modify default analyzer */
    int ERROR_CANNOTMODIFY_DEFAULTANALYZER = -536858363;

    /** zh_info: 分析单元IP端口冲突 ; en_info: analyzer ip port conflict */
    int ERROR_ANALYZER_IPPORT_CONFICT = -536858362;

    /** zh_info: 正在同步设备 ; en_info: device int synchronizing state */
    int ERROR_DEVICE_SYNCHRONIZING = -536858361;

    /** zh_info: 上传文件无人接收 ; en_info: file has no receiver */
    int ERROR_FILE_NO_RECV_DES = -536858624;

    /** zh_info: 不合法的服务配置文件 ; en_info: invalid configfile */
    int ERROR_INVALID_CONFIGFILE = -536858623;

    /** zh_info: 文件夹创建失败 ; en_info: create folder fail */
    int ERROR_CREATE_FOLDER_FAILED = -536858622;

    /** zh_info: 解密失败 ; en_info: decrypt fail */
    int ERROR_DECRYPT_FAILED = -536858621;

    /** zh_info: 不合法的安装包 ; en_info: invalid package */
    int ERROR_INVALID_PACKAGE = -536858620;

    /** zh_info: 上传安装包已存在 ; en_info: package already exist */
    int ERROR_PACKAGE_EXIST = -536858619;

    /** zh_info: 安装失败 ; en_info: setup failed */
    int ERROR_SETUP_FAILED = -536858618;

    /** zh_info: 需要关联的服务已存在 ; en_info: relate service exist */
    int ERROR_SERVERID_EXIST = -536858617;

    /** zh_info: 错误的文件信息 ; en_info: invalid file info */
    int ERROR_INVALID_FILEINFO = -536858616;

    /** zh_info: 错误的版本信息 ; en_info: invalid version */
    int ERROR_INVALID_VERSION = -536858615;

    /** zh_info: 抓包任务已存在 ; en_info: capture task already exists */
    int ERROR_EXIST_CAP_TASK = -536858612;

    /** zh_info: 关联NVR失败，未找到NVR模板 ; en_info: Association NVR fails, NVR template not found */
    int ERROR_NOT_FIND_NVR_TEMPLATE = -536858102;

    /** zh_info: 超出NVR模板允许关联摄像头上限 ; en_info: NVR template associated exceeded the maximum allowed camera */
    int ERROR_OUT_OF_MAX_NVR_CHANNEL = -536858101;

    /** zh_info: 该摄像头已有NVR关联 ; en_info: The camera has been associated with NVR */
    int ERROR_EXIST_CAMERA_LINK_NVR = -536858100;

    /** zh_info: 获取文件块失败 ; en_info: Get File Block Failed */
    int ERROR_GETUSERBLOCK = -536858112;

    /** zh_info: 打开文件失败 ; en_info: Open File Failed */
    int ERROR_OPENFILE = -536858111;

    /** zh_info: 写文件失败 ; en_info: Write File Failed */
    int ERROR_STORE_WRITE = -536858110;

    /** zh_info: 超出转发关联的最大负荷 ; en_info: Beyond the maximum dispatch server capacity */
    int ERROR_OUT_OF_DISPATCH_ABILITY = -536858097;

    /** zh_info: 该摄像头下已经有预置位巡检队列在运行中 ; en_info: The camera has a preset patrol queue in operation */
    int ERROR_CAMERA_PRESET_CRUISE_EXIST = -536858096;

    /** en_info="Fail To Delete NMS DEVICE Which Has Child Device" zh_info="网管设备下面有关联设备，不能删除" */
    int ERROR_HAVE_CHILD_DEVICE = -536860002;

    int ERROR_DOMAIN_REPEAT = -536861889;
    //门数量不匹配
    int ERROR_DOOR_NUMBER = -600000071;
    //模板中没有匹配的巡检项目
    int ERROR_NOT_FIND_PATROLITEM = -600000080;
    /** en_info="Alarm upgrade step cannot be null" zh_info="告警升级步骤不能为空" */
    int ERROR_STEPS_IS_NESSARY = -600001000;
    //批量新增机柜时关联关系错误
    int ERROR_CABINET_METE_RELATION = -600000086;
    /** en_info="Alarm upgrade mete cannot be null" zh_info="告警升级测点不能为空" */
    int ERROR_UPGRADE_METE_NESSARY = -600001001;

    /** en_info="Invalid adjust value" zh_info="遥调值超出范围" */
    int INVALID_ADJUST_VALUE = -600000097;
    
}
