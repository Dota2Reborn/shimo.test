package elementFile;

import org.openqa.selenium.WebElement;

public class elementFile {
	/**
	 * Login
	 * homePage
	 * 登录页面
	 *
	 */
	@SearchWith(pageName = "homePage", elementName = "userEmail", noteName = "用户名")
	public WebElement userEmail;
	@SearchWith(pageName = "homePage", elementName = "userPwd", noteName = "密码")
	public WebElement userPwd;
	@SearchWith(pageName = "homePage", elementName = "login_submit", noteName = "登录按钮")
	public WebElement login_submit;

	/**
	 * 
	 * desktop
	 * 我的桌面
	 *
	 */
	@SearchWith(pageName = "desktop", elementName = "desktop_new", noteName = "新建文件按钮")
	public WebElement desktop_new;
	@SearchWith(pageName = "desktop", elementName = "desktop_show_type", noteName = "列表平铺模式切换")
	public WebElement desktop_show_type;
	@SearchWith(pageName = "desktop", elementName = "desktop", noteName = "切换到我的桌面")
	public WebElement desktop;
	@SearchWith(pageName = "desktop", elementName = "desktop1_1", noteName = "平铺模式第一行第一个文件")
	public WebElement desktop1_1;
	@SearchWith(pageName = "desktop", elementName = "desktop1_2", noteName = "平铺模式第一行第二个文件")
	public WebElement desktop1_2;
	@SearchWith(pageName = "desktop", elementName = "desktop_newDoc", noteName = "新建文档")
	public WebElement desktop_newDoc;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder_name_ok", noteName = "文件夹命名确定,退出共享确认")
	public WebElement desktop_newFolder_name_ok;
	@SearchWith(pageName = "desktop", elementName = "desktop1_1_folder", noteName = "平铺模式第一行第一个文件夹")
	public WebElement desktop1_1_folder;
	@SearchWith(pageName = "desktop", elementName = "desktop1_2_folder", noteName = "平铺模式第一行第二个文件夹")
	public WebElement desktop1_2_folder;
	@SearchWith(pageName = "desktop", elementName = "desktop1_3_folder", noteName = "平铺模式第一行第三个文件夹")
	public WebElement desktop1_3_folder;
	@SearchWith(pageName = "desktop", elementName = "desktop_list_1_file", noteName = "列表模式第一个文件")
	public WebElement desktop_list_1_file;
	@SearchWith(pageName = "desktop", elementName = "desktop_list_2_file", noteName = "列表模式第二个文件")
	public WebElement desktop_list_2_file;
	@SearchWith(pageName = "desktop", elementName = "desktop_list_3_file", noteName = "列表模式第三个文件")
	public WebElement desktop_list_3_file;
	@SearchWith(pageName = "desktop", elementName = "desktop_order", noteName = "桌面排序")
	public WebElement desktop_order;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByUpdate", noteName = "桌面排序-按更新时间")
	public WebElement desktop_orderByUpdate;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByCreate", noteName = "桌面排序-按创建时间")
	public WebElement desktop_orderByCreate;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByFile", noteName = "桌面排序-文件名")
	public WebElement desktop_orderByFile;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByOwner", noteName = "桌面排序-所有者")
	public WebElement desktop_orderByOwner;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByFolderUP", noteName = "桌面排序-文件夹置顶")
	public WebElement desktop_orderByFolderUP;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByDefault", noteName = "桌面排序-默认")
	public WebElement desktop_orderByDefault;
	@SearchWith(pageName = "desktop", elementName = "desktop_newSheet", noteName = "新建表格")
	public WebElement desktop_newSheet;
	@SearchWith(pageName = "desktop", elementName = "desktop_newslides", noteName = "新建幻灯片")
	public WebElement desktop_newslides;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder", noteName = "新建文件夹")
	public WebElement desktop_newFolder;
	@SearchWith(pageName = "desktop", elementName = "desktop_import", noteName = "导入")
	public WebElement desktop_import;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder_name", noteName = "文件夹命名")
	public WebElement desktop_newFolder_name;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder_name_cancel", noteName = "文件夹命名取消")
	public WebElement desktop_newFolder_name_cancel;
	@SearchWith(pageName = "desktop", elementName = "desktop_set", noteName = "hover文件的齿轮")
	public WebElement desktop_setting;
	@SearchWith(pageName = "desktop", elementName = "desktop_shortcut_1", noteName = "桌面快捷方式第一个")
	public WebElement desktop_shortcut_1;
	@SearchWith(pageName = "desktop", elementName = "desktop_shortcut_Increase", noteName = "新增桌面快捷方式区域")
	public WebElement desktop_shortcut_Increase;
	@SearchWith(pageName = "desktop", elementName = "desktop_shortcut_Tips", noteName = "新增快捷方式区域提示")
	public WebElement desktop_shortcut_Tips;
	@SearchWith(pageName = "desktop", elementName = "desktop_moveFolder_button", noteName = "移动到测试文件夹")
	public WebElement desktop_moveFolder_button;
	@SearchWith(pageName = "desktop", elementName = "desktop_moveFolder_back_button", noteName = "移动文件到文件夹，列表中后退按钮")
	public WebElement desktop_moveFolder_back_button;
	@SearchWith(pageName = "desktop", elementName = "desktop_moveFolder_list_1", noteName = "移动文件到文件夹，选择列表中第一个文件夹")
	public WebElement desktop_moveFolder_list_1;
	@SearchWith(pageName = "desktop", elementName = "desktop_moveFolder_list_2", noteName = "移动文件到文件夹，选择列表中第二个文件夹")
	public WebElement desktop_moveFolder_list_2;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderHeader_1", noteName = "表头文件名排序")
	public WebElement desktop_orderHeader_1;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderHeader_2", noteName = "表头所有者排序")
	public WebElement desktop_orderHeader_2;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderHeader_3", noteName = "表头时间排序")
	public WebElement desktop_orderHeader_3;
	@SearchWith(pageName = "desktop", elementName = "desktop1_1_name", noteName = "获取第一个文件名称")
	public WebElement desktop1_1_name;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByFolderUP_Hook", noteName = "桌面排序-文件夹置顶-对钩")
	public WebElement desktop_orderByFolderUP_Hook;
	@SearchWith(pageName = "desktop", elementName = "folder_backToDesktop", noteName = "文件夹中，点击文件路径返回我的桌面")
	public WebElement folder_backToDesktop;

	/**
	 * doc
	 * 文档表格相关
	 *
	 */
	@SearchWith(pageName = "doc", elementName = "b_back", noteName = "后退")
	public WebElement b_back;
	@SearchWith(pageName = "doc", elementName = "doc_title_input", noteName = "文档标题编辑")
	public WebElement doc_title_input;
	@SearchWith(pageName = "doc", elementName = "doc_saveStatus", noteName = "文档/表格提示同步完成状态")
	public WebElement doc_saveStatus;
	@SearchWith(pageName = "doc", elementName = "quick_access_point", noteName = "收索&快速打开")
	public WebElement quick_access_point;
	@SearchWith(pageName = "doc", elementName = "Back_to_Desktop", noteName = "一级文件夹下的文档或者表格中，下箭头直接返回桌面")
	public WebElement Back_to_Desktop;
	@SearchWith(pageName = "doc", elementName = "Back_to_Table", noteName = "一级文件夹下的文档或者表格中，下箭头直接返回工作台")
	public WebElement Back_to_Table;
	@SearchWith(pageName = "doc", elementName = "doc_edit", noteName = "文档编辑入口")
	public WebElement doc_edit;
	@SearchWith(pageName = "doc", elementName = "doc_notice_user", noteName = "@用户，被选列表中内容第一个用户")
	public WebElement doc_notice_user;
	@SearchWith(pageName = "doc", elementName = "doc_menu", noteName = "文档编辑页面中右上角 点点点")
	public WebElement doc_menu;
	@SearchWith(pageName = "doc", elementName = "doc_menu_msg", noteName = "文档编辑页面中右上角 点点点-文档信息")
	public WebElement doc_menu_msg;
	@SearchWith(pageName = "doc", elementName = "doc_menu_delete", noteName = "文档编辑页面中右上角 点点点-删除文档")
	public WebElement doc_menu_delete;
	@SearchWith(pageName = "doc", elementName = "doc_menu_delete_OK", noteName = "文档编辑页面中右上角 点点点-删除文档-确定按钮")
	public WebElement doc_menu_delete_OK;
	@SearchWith(pageName = "doc", elementName = "doc_discuss", noteName = "文档编辑页面中评论按钮")
	public WebElement doc_discuss;
	@SearchWith(pageName = "doc", elementName = "doc_discuss_input", noteName = "文档编辑页面中评论输入框")
	public WebElement doc_discuss_input;
	@SearchWith(pageName = "doc", elementName = "doc_discuss_input_ok", noteName = "文档编辑页面中评论输入框-确定按钮")
	public WebElement doc_discuss_input_ok;
	@SearchWith(pageName = "doc", elementName = "ql_comment_Comments", noteName = "工具栏中发起评论按钮")
	public WebElement ql_comment_Comments;
	@SearchWith(pageName = "doc", elementName = "Folder_settings", noteName = "文件夹中上方设置按钮")
	public WebElement Folder_settings;
	@SearchWith(pageName = "doc", elementName = "Exit_share_OK", noteName = "管理员删除文档-选择退出共享")
	public WebElement Exit_share_OK;
	@SearchWith(pageName = "doc", elementName = "Collection_OK", noteName = "标题栏收藏按钮")
	public WebElement Collection_OK;
	@SearchWith(pageName = "doc", elementName = "End_Discussion", noteName = "结束讨论")
	public WebElement End_Discussion;
	@SearchWith(pageName = "doc", elementName = "End_Discussion_OK", noteName = "确定结束讨论")
	public WebElement End_Discussion_OK;

	/**
	 * dashboard
	 * 工作台
	 *
	 */
	@SearchWith(pageName = "dashboard", elementName = "dashboard_update_time", noteName = "工作台-最近更新-更新时间")
	public WebElement dashboard_update_time;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_update_file", noteName = "工作台-共享给我的-文件")
	public WebElement dashboard_update_file;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_update_name", noteName = "工作台-最近更新-文件名")
	public WebElement dashboard_update_name;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_shareTime_1", noteName = "新的共享-大标签-更新时间")
	public WebElement dashboard_shareTime_1;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_shareTime_unread", noteName = "新的共享-大标签-标记已读")
	public WebElement dashboard_shareTime_unread;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_share_file_1", noteName = "工作台第一行第一个文件")
	public WebElement dashboard_share_file_1;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_share_file_favorites", noteName = "工作台第一行第一个文件收藏按钮")
	public WebElement dashboard_share_file_favorites;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_share_file_2", noteName = "工作台第一行第二个文件")
	public WebElement dashboard_share_file_2;
	@SearchWith(pageName = "dashboard", elementName = "New_Share_1", noteName = "新的共享第一个")
	public WebElement New_Share_1;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_1", noteName = "工作台-最近更新")
	public WebElement dashboard_1;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_2", noteName = "工作台-最近使用")
	public WebElement dashboard_2;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_3", noteName = "工作台-我创建的")
	public WebElement dashboard_3;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_4", noteName = "工作台-共享给我的")
	public WebElement dashboard_4;
	@SearchWith(pageName = "dashboard", elementName = "dashboard", noteName = "切换到工作台")
	public WebElement dashboard;
	@SearchWith(pageName = "dashboard", elementName = "favorites", noteName = "切换到我的收藏")
	public WebElement favorites;
	@SearchWith(pageName = "dashboard", elementName = "trash", noteName = "切换到回收站")
	public WebElement trash;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_search_button", noteName = "桌面搜索按钮")
	public WebElement dashboard_search_button;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_search_input", noteName = "桌面搜索输入框")
	public WebElement dashboard_search_input;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_search_result_1", noteName = "桌面搜索结果第一行")
	public WebElement dashboard_search_result_1;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_notice", noteName = "桌面通知铃铛")
	public WebElement dashboard_notice;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_notice_list_1", noteName = "桌面通知铃铛-通知列表中第一个")
	public WebElement dashboard_notice_list_1;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_notice_list_1_button", noteName = "桌面通知铃铛-通知列表中第一个-按钮")
	public WebElement dashboard_notice_list_1_button;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_notice_list_1_time", noteName = "桌面通知铃铛-通知列表中第一个时间")
	public WebElement dashboard_notice_list_1_time;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_notice_list_unread", noteName = "桌面通知铃铛-未读")
	public WebElement dashboard_notice_list_unread;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_notice_list_allRead", noteName = "桌面通知铃铛-标记全部已读")
	public WebElement dashboard_notice_list_allRead;
	
	@SearchWith(pageName = "dashboard", elementName = "desktop_user_icon", noteName = "桌面-右上角头像")
	public WebElement desktop_user_icon;
	@SearchWith(pageName = "dashboard", elementName = "desktop_user_icon_companyManagement", noteName = "桌面-右上角头像-我的企业")
	public WebElement desktop_user_icon_companyManagement;
	@SearchWith(pageName = "dashboard", elementName = "desktop_user_icon_personSetting", noteName = "桌面-右上角头像-账号设置")
	public WebElement desktop_user_icon_personSetting;
	@SearchWith(pageName = "dashboard", elementName = "desktop_user_icon_status_L", noteName = "桌面-右上角头像-当前账号状态-左边，如高级版，购买企业版")
	public WebElement desktop_user_icon_status_L;
	@SearchWith(pageName = "dashboard", elementName = "desktop_user_icon_status_R", noteName = "桌面-右上角头像-当前账号状态-右边，如企业版过期，企业试用中，企业名称等")
	public WebElement desktop_user_icon_status_R;
	
	/**
	 * addCollaborator
	 * 协作者相关
	 *
	 */
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_close", noteName = "关闭添加协作者弹框")
	public WebElement button_addCollaborator_close;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_1_list", noteName = "协作者列表第一个协作者权限下拉框")
	public WebElement b_addCollaborator_1_list;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_2_list", noteName = "协作者列表第二个协作者权限下拉框")
	public WebElement b_addCollaborator_2_list;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_3_list", noteName = "协作者列表第三个协作者权限下拉框")
	public WebElement b_addCollaborator_3_list;
	@SearchWith(pageName = "addCollaborator", elementName = "list_addCollaborator_1", noteName = "协作者权限列表--转让所有权")
	public WebElement list_addCollaborator_1;
	@SearchWith(pageName = "addCollaborator", elementName = "list_addCollaborator_4", noteName = "协作者权限列表--移除")
	public WebElement list_addCollaborator_4;
	@SearchWith(pageName = "addCollaborator", elementName = "list_addCollaborator_4_ok", noteName = "协作者权限列表--移除--确认移除")
	public WebElement list_addCollaborator_4_ok;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_total", noteName = "协作者人数")
	public WebElement addCollaborator_total;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_1_add", noteName = "最近协作者列表第一个添加按钮")
	public WebElement addCollaborator_1_add;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_companyList_2_add", noteName = "企业协作者列表第二个添加按钮")
	public WebElement addCollaborator_companyList_2_add;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_company_list", noteName = "协作者页面切换到企业成员列表")
	public WebElement addCollaborator_company_list;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_back", noteName = "从协作者列表返回按钮")
	public WebElement b_addCollaborator_back;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_confirm", noteName = "协作者移除或者降低自己权限时提示弹窗的确定按钮")
	public WebElement b_addCollaborator_confirm;
	@SearchWith(pageName = "addCollaborator", elementName = "list_addCollaborator_changeOwner_1", noteName = "协作者权限列表--转让所有权列表--选择第一个用户为转让对象按钮")
	public WebElement list_addCollaborator_changeOwner_1;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_1_list_userName", noteName = "协作者列表第一个协作者用户名")
	public WebElement addCollaborator_1_list_userName;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_2_list_userName", noteName = "协作者列表第二个协作者用户名")
	public WebElement addCollaborator_2_list_userName;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_folder_add", noteName = "文件夹内右侧(加号)添加协作人按钮")
	public WebElement addCollaborator_folder_add;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator", noteName = "添加协作者按钮")
	public WebElement button_addCollaborator;
	@SearchWith(pageName = "addCollaborator", elementName = "input_addCollaborator", noteName = "添加协作者邮箱输入框")
	public WebElement input_addCollaborator;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_1_add", noteName = "搜索显示被添加协作者列表第一个添加按钮")
	public WebElement b_addCollaborator_1_add;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_ok", noteName = "确认添加协作者按钮")
	// 王继程3/12
	public WebElement b_addCollaborator_ok;
	@SearchWith(pageName = "addCollaborator", elementName = "Can_edit_1", noteName = "可以编辑")
	public WebElement Can_edit_1;
	@SearchWith(pageName = "addCollaborator", elementName = "can_only_comment_2", noteName = "只能评论")
	public WebElement can_only_comment_2;
	@SearchWith(pageName = "addCollaborator", elementName = "can_only_read_3", noteName = "只能阅读")
	public WebElement can_only_read_3;
	@SearchWith(pageName = "addCollaborator", elementName = "Shut_down_sm_modal_close_x", noteName = "关闭添加协作窗口")
	public WebElement Shut_down_sm_modal_close_x;

	/**
	 * companyManagement
	 * 企业管理相关
	 *
	 */
	@SearchWith(pageName = "companyManagement", elementName = "company_Management", noteName = "桌面-企业管理入口")
	public WebElement company_Management;
	@SearchWith(pageName = "companyManagement", elementName = "company_setting", noteName = "企业管理-企业设置")
	public WebElement company_setting;
	@SearchWith(pageName = "companyManagement", elementName = "invite_member", noteName = "企业设置-谁能邀请新成员进企业")
	public WebElement invite_member;
	@SearchWith(pageName = "companyManagement", elementName = "invite_member_OK", noteName = "企业设置-谁能邀请新成员进企业-保存按钮")
	public WebElement invite_member_OK;
	@SearchWith(pageName = "companyManagement", elementName = "invite_member_1", noteName = "企业设置-谁能邀请新成员进企业-所有企业成员")
	public WebElement invite_member_1;
	@SearchWith(pageName = "companyManagement", elementName = "invite_member_2", noteName = "企业设置-谁能邀请新成员进企业-仅企业创建者和管理员")
	public WebElement invite_member_2;
	@SearchWith(pageName = "companyManagement", elementName = "invite_member_3", noteName = "企业设置-谁能邀请新成员进企业-仅企业创建者")
	public WebElement invite_member_3;
	@SearchWith(pageName = "companyManagement", elementName = "addMember", noteName = "成员管理-添加成员按钮")
	public WebElement addMember;
	@SearchWith(pageName = "companyManagement", elementName = "address_cppy", noteName = "企业设置-添加成员-复制链接按钮")
	public WebElement address_cppy;
	@SearchWith(pageName = "companyManagement", elementName = "message_ok", noteName = "消息确认按钮")
	public WebElement message_ok;
	@SearchWith(pageName = "companyManagement", elementName = "message_warning", noteName = "提示消息")
	public WebElement message_warning;
	@SearchWith(pageName = "companyManagement", elementName = "button_companyName", noteName = "企业设置-企业名称（更改按钮）")
	public WebElement button_companyName;
	@SearchWith(pageName = "companyManagement", elementName = "input_companyName", noteName = "企业设置-企业名称")
	public WebElement input_companyName;
	@SearchWith(pageName = "companyManagement", elementName = "text_companyName", noteName = "企业设置-企业名称（输入框）")
	public WebElement text_companyName;
	@SearchWith(pageName = "companyManagement", elementName = "setAdmin", noteName = "企业设置-设置管理员")
	public WebElement setAdmin;
	@SearchWith(pageName = "companyManagement", elementName = "setAdmin_ManagerAndCreater", noteName = "企业设置-设置管理员-管理员和创建者")
	public WebElement setAdmin_ManagerAndCreater;
	@SearchWith(pageName = "companyManagement", elementName = "setAdmin_Creater", noteName = "企业设置-设置管理员-仅创建者")
	public WebElement setAdmin_Creater;
	@SearchWith(pageName = "companyManagement", elementName = "button_addCollaborators", noteName = "企业设置-谁能添加外部协作者（更改按钮）")
	public WebElement button_addCollaborators;
	@SearchWith(pageName = "companyManagement", elementName = "addCollaborators_1", noteName = "企业设置-谁能添加外部协作者-所有企业成员")
	public WebElement addCollaborators_1;
	@SearchWith(pageName = "companyManagement", elementName = "addCollaborators_2", noteName = "企业设置-谁能添加外部协作者-仅企业创建者和管理员")
	public WebElement addCollaborators_2;
	@SearchWith(pageName = "companyManagement", elementName = "addCollaborators_3", noteName = "企业设置-谁能添加外部协作者-仅企业创建者和管理员，以及文件所有者")
	public WebElement addCollaborators_3;
	@SearchWith(pageName = "companyManagement", elementName = "transferCompany", noteName = "企业设置-移交企业")
	public WebElement transferCompany;
	@SearchWith(pageName = "companyManagement", elementName = "transferCompany_button", noteName = "企业设置-移交企业-移交企业确认按钮")
	public WebElement transferCompany_button;
	@SearchWith(pageName = "companyManagement", elementName = "memberSearch", noteName = "企业设置-成员列表-搜索")
	public WebElement memberSearch;
	@SearchWith(pageName = "companyManagement", elementName = "xpath_banUser_2", noteName = "企业设置-成员列表-移除成员-禁用")
	public WebElement xpath_banUser_2;
	@SearchWith(pageName = "companyManagement", elementName = "xpath_banUser_ok", noteName = "企业设置-成员列表-移除成员-禁用-确认")
	public WebElement xpath_banUser_ok;
	@SearchWith(pageName = "companyManagement", elementName = "xpath_userTab_1", noteName = "企业设置-成员列表")
	public WebElement xpath_userTab_1;
	@SearchWith(pageName = "companyManagement", elementName = "xpath_userTab_3", noteName = "企业设置-禁用成员列表")
	public WebElement xpath_userTab_3;
	@SearchWith(pageName = "companyManagement", elementName = "button_exitCompany", noteName = "企业设置-成员退出企业")
	public WebElement button_exitCompany;
	@SearchWith(pageName = "companyManagement", elementName = "addmember_copyLink_open", noteName = "企业设置-打开或者关闭邀请链接")
	public WebElement addmember_copyLink_open;

	

	/**
	 * Registered
	 * 注册页面相关
	 *
	 */
	@SearchWith(pageName = "Registered", elementName = "userName", noteName = "昵称")
	public WebElement userName;
	@SearchWith(pageName = "Registered", elementName = "userEmail", noteName = "登录邮箱")
	public WebElement Email;
	@SearchWith(pageName = "Registered", elementName = "userPwd", noteName = "密码")
	public WebElement Pwd;
	@SearchWith(pageName = "Registered", elementName = "Next", noteName = "下一步")
	public WebElement Next;

	/**
	 * menu
	 * 桌面工作台菜单
	 *
	 */
	@SearchWith(pageName = "menu", elementName = "menu_newPage", noteName = "新标签页中打开")
	public WebElement menu_newPage;
	@SearchWith(pageName = "menu", elementName = "menu_shortcut", noteName = "添加到快捷方式")
	public WebElement menu_shortcut;
	@SearchWith(pageName = "menu", elementName = "menu_collection", noteName = "收藏")
	public WebElement menu_collection;
	@SearchWith(pageName = "menu", elementName = "menu_cooperation", noteName = "添加协作者")
	public WebElement menu_cooperation;
	@SearchWith(pageName = "menu", elementName = "menu_move", noteName = "移动")
	public WebElement menu_move;
	@SearchWith(pageName = "menu", elementName = "menu_share", noteName = "分享")
	public WebElement menu_share;
	@SearchWith(pageName = "menu", elementName = "menu_share_1", noteName = "分享-公开分享")
	public WebElement menu_share_1;
	@SearchWith(pageName = "menu", elementName = "menu_rename", noteName = "重命名")
	public WebElement menu_rename;
	@SearchWith(pageName = "menu", elementName = "menu_creatCopy", noteName = "创建副本")
	public WebElement menu_creatCopy;
	@SearchWith(pageName = "menu", elementName = "menu_delete", noteName = "删除")
	public WebElement menu_delete;
	@SearchWith(pageName = "menu", elementName = "menu_mute", noteName = "消息免打扰")
	public WebElement menu_mute;
	@SearchWith(pageName = "menu", elementName = "menu_moveToFolder", noteName = "定位到所在文件夹")
	public WebElement menu_moveToFolder;
	@SearchWith(pageName = "menu", elementName = "menu_Recovery", noteName = "恢复文件")
	public WebElement menu_Recovery;
	@SearchWith(pageName = "menu", elementName = "menu_Completely_removed", noteName = "彻底删除")
	public WebElement menu_Completely_removed;
	@SearchWith(pageName = "menu", elementName = "menu_Point_Menu", noteName = "工作台-最近使用-第一个文件点点(仅有一个文件时使用)")
	public WebElement menu_Point_Menu;
	@SearchWith(pageName = "menu", elementName = "menu_cooperation_1", noteName = "添加协作者-二级菜单（添加协作者）")
	public WebElement menu_cooperation_1;
	@SearchWith(pageName = "menu", elementName = "menu_cooperation_2", noteName = "添加协作者-二级菜单（查看协作者）")
	public WebElement menu_cooperation_2;

	/**
	 * file_menu
	 * 文档表格编辑页点点等-菜单
	 *
	 */
	@SearchWith(pageName = "file_menu", elementName = "file_menu_version", noteName = "保存版本")
	public WebElement file_menu_version;
	@SearchWith(pageName = "file_menu", elementName = "file_menu_shortcut", noteName = "添加快捷方式")
	public WebElement file_menu_shortcut;
	@SearchWith(pageName = "file_menu", elementName = "file_menu_collection", noteName = "添加收藏")
	public WebElement file_menu_collection;
	@SearchWith(pageName = "file_menu", elementName = "file_menu_list", noteName = "查看目录")
	public WebElement file_menu_list;
	@SearchWith(pageName = "file_menu", elementName = "file_menu_move", noteName = "移动")
	public WebElement file_menu_move;
	@SearchWith(pageName = "file_menu", elementName = "file_menu_history", noteName = "查看历史")
	public WebElement file_menu_history;
	@SearchWith(pageName = "file_menu", elementName = "file_menu_creatCopy", noteName = "创建副本")
	public WebElement file_menu_creatCopy;
	@SearchWith(pageName = "file_menu", elementName = "file_menu_delete", noteName = "删除")
	public WebElement file_menu_delete;
	@SearchWith(pageName = "file_menu", elementName = "file_menu_mute", noteName = "消息免打扰")
	public WebElement file_menu_mute;
	@SearchWith(pageName = "file_menu", elementName = "file_menu_msg", noteName = "文档信息")
	public WebElement file_menu_msg;
	@SearchWith(pageName = "file_menu", elementName = "file_menu_help", noteName = "帮助")
	public WebElement file_menu_help;
	
	
	/**
	 * ppt
	 * PPT_演示页面
	 *
	 */
	@SearchWith(pageName = "ppt", elementName = "add_page", noteName = "添加页面")
	public WebElement add_page;
	@SearchWith(pageName = "ppt", elementName = "down_arrow", noteName = "下箭头")
	public WebElement down_arrow;
	@SearchWith(pageName = "ppt", elementName = "ppt_revoke", noteName = "撤销")
	public WebElement ppt_revoke;
	@SearchWith(pageName = "ppt", elementName = "ppt_redo", noteName = "重做")
	public WebElement ppt_redo;
	@SearchWith(pageName = "ppt", elementName = "add_title", noteName = "添加标题")
	public WebElement add_title;
	@SearchWith(pageName = "ppt", elementName = "add_text", noteName = "添加文本")
	public WebElement add_text;
	@SearchWith(pageName = "ppt", elementName = "add_diagram", noteName = "添加图片")
	public WebElement add_diagram;
	@SearchWith(pageName = "ppt", elementName = "add_arrows", noteName = "添加箭头")
	public WebElement add_arrows;
	@SearchWith(pageName = "ppt", elementName = "add_Rectangle", noteName = "添加矩形")
	public WebElement add_Rectangle;
	@SearchWith(pageName = "ppt", elementName = "add_circular", noteName = "添加圆形")
	public WebElement add_circular;
	@SearchWith(pageName = "ppt", elementName = "ppt_page_1", noteName = "左边栏第一个页面")
	public WebElement ppt_page_1;
	@SearchWith(pageName = "ppt", elementName = "ppt_page_2", noteName = "左边栏第二个页面")
	public WebElement ppt_page_2;
	@SearchWith(pageName = "ppt", elementName = "ppt_page_3", noteName = "左边栏第三个页面")
	public WebElement ppt_page_3;
	@SearchWith(pageName = "ppt", elementName = "ppt_page_4", noteName = "左边栏第四个页面")
	public WebElement ppt_page_4;
	@SearchWith(pageName = "ppt", elementName = "ppt_page_5", noteName = "左边栏第五个页面")
	public WebElement ppt_page_5;
	@SearchWith(pageName = "ppt", elementName = "ppt_page_6", noteName = "左边栏第六个页面")
	public WebElement ppt_page_6;
	@SearchWith(pageName = "ppt", elementName = "ppt_page_7", noteName = "左边栏第七个页面")
	public WebElement ppt_page_7;
	@SearchWith(pageName = "ppt", elementName = "ppt_page_8", noteName = "左边栏第八个页面")
	public WebElement ppt_page_8;
	@SearchWith(pageName = "ppt", elementName = "ppt_page_9", noteName = "左边栏第九个页面")
	public WebElement ppt_page_9;
	@SearchWith(pageName = "ppt", elementName = "page_elements_1", noteName = "幻灯片页面第一个元素")
	public WebElement page_elements_1;
	@SearchWith(pageName = "ppt", elementName = "page_elements_2", noteName = "幻灯片页面第二个元素")
	public WebElement page_elements_2;
	@SearchWith(pageName = "ppt", elementName = "page_elements_3", noteName = "幻灯片页面第三个元素")
	public WebElement page_elements_3;
	@SearchWith(pageName = "ppt", elementName = "page_elements_4", noteName = "幻灯片页面第四个元素")
	public WebElement page_elements_4;
	@SearchWith(pageName = "ppt", elementName = "page_elements_5", noteName = "幻灯片页面第五个元素")
	public WebElement page_elements_5;
}
