package ygsama.common;

public class StatusEnum {

	/**
	 * 加钞计划状态
	 * 
	 */
	public enum AddnotesPlanStatus {
		DEV_NOTCHOOSE(0,"未选择设备"), DEV_CHOOSE(1, "已选择设备"), AMOUNT_PREDICTED(2, "已预测金额"), GROUPED(3, "已分组"), 
	    SUBMITTED(4, "已出单"), OUTDATE(5, "已过期");
		
		private int id;
		private String name;
		
		private AddnotesPlanStatus(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public int getId() {
			return this.id;
		}
		
		public String getName() {
			return this.name;
		}

		/**
		 * 判断当前状态能否分组
		 * 
		 * @param status
		 * @return
		 */
		public static boolean canGroup(int status) {
			return status == AMOUNT_PREDICTED.getId() || status == GROUPED.getId();
		}

		/**
		 * 判断当前状态能否排序
		 * 
		 * @param status
		 * @return
		 */
		public static boolean canSort(int status) {
			return status >= GROUPED.getId();
		}
	}
	
	
	/**
	 * 加钞任务状态
	 * 
	 */
	public enum DispatchStatus {
		UNASSIGNED(1, "未分配人员"), UNAUDITTED(2, "待审批"), AUDITTED(3, "审批通过"), REFUSED(4, "退回调整"), CANCELED(5, "已取消"), 
		OUTDATE(6, "已过期");
		
		private int id;
		private String name;
		
		private DispatchStatus(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public int getId() {
			return this.id;
		}
		
		public String getName() {
			return this.name;
		}
	}
	
	/**
	 * 设备各模块信息
	 * @author yt
	 * @since 2013-05-16
	 *
	 */
	public enum ModName {
		IDC("IDC", "读卡器"),
		CHK("CHK", "支票读扫描"),
		PBK("PBK", "存折"),
		PIN("PIN", "密码键盘"),
		SIU("SIU", "传感器"),
		DEP("DEP", "信封存款"),
		CAM("CAM", "照相机"),
		CIM("CIM", "存款"),
		CDM("CDM", "取款"),
		SPR("SPR", "结单打印机"),
		RPR("RPR", "凭条打印机"),
		JPR("JPR", "日志打印机"),
		TTU("TTU", "文本终端");
		
		private String id;
		private String name;
		
		private ModName(String id, String name){
			this.id = id;
			this.name = name;
		}
		
		public String getId() {
			return id;
		}
		public String getName() {
			return name;
		}
	}
	

	/**
	 * 是否开通循环
	 * @author yt
	 * @since 2013-08-21
	 */
	public enum CycleFlag {
		UNCYCLE(0, "未开通循环"), ISCYCLE(1, "已开通循环");
		
		private int id;
		private String name;
		
		private CycleFlag(int id, String name){
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}
	}
	/**
	 * 设备类型
	 */
	public enum DevCatalog {
		ATM(10003, "ATM"), CRS(10001, "CRS");
		
		private int id;
		private String name;
		
		private DevCatalog(int id, String name){
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}
	}
	/**
	 * 银行机构等级
	 * 
	 * @author yyc
	 * 
	 */
	public enum OrgGrade {
		HEAD_BANK(1, "总行"), BRANCH_BANK(2, "分行"), SUB_BRANCH_BANK(3, "支行"), NETPOINT(4, "网点");

		private int no;
		private String name;

		private OrgGrade(int no, String name) {
			this.no = no;
			this.name = name;
		}

		public int getNo() {
			return this.no;
		}

		public String getName() {
			return this.name;
		}
	}
	
	/**
	 * 矩阵-点类型
	 * 
	 * @author yyc
	 * 
	 */
	public enum MatrixPointType {
		CENTER(0), NETPOINT(1);
		private int value;

		private MatrixPointType(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}

		public static boolean checkIn(int value) {
			for (MatrixPointType temp : MatrixPointType.values()) {
				if (temp.getValue() == value) {
					return true;
				}
			}
			return false;
		}
	}
	
	/**
	 * 矩阵-类型
	 * 
	 * @author yyc
	 * 
	 */
	public enum MatrixType {
		ALL(-1), N_TO_N(0), C_TO_N(1), N_TO_C(2);
		private int value;

		private MatrixType(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}

		public static boolean checkIn(int value) {
			for (MatrixType temp : MatrixType.values()) {
				if (temp.getValue() == value) {
					return true;
				}
			}
			return false;
		}

		public static boolean checkDefinite(int value) {
			return MatrixType.checkIn(value) && value != MatrixType.ALL.getValue();
		}
	}
	
	/**
	 * 矩阵-策略
	 * 
	 * @author yyc
	 * 
	 */
	public enum MatrixTactic {
		ALL(-1), DISTANCE_SHORTEST(13), TIME_SHORTEST(11), NO_EXPRESS(10);
		private int value;

		private MatrixTactic(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}

		public static boolean checkIn(int value) {
			for (MatrixTactic temp : MatrixTactic.values()) {
				if (temp.getValue() == value) {
					return true;
				}
			}
			return false;
		}

		public static boolean checkDefinite(int value) {
			return MatrixTactic.checkIn(value) && value != MatrixTactic.ALL.getValue();
		}
	}
	
	/**
	 * 加钞任务明细状态
	 */
	public enum DispatchDetailStatus {
		UNAUDITTED(0, "未审批通过"), AUDITTED(1, "已审批通过");
		
		private int id;
		private String name;
		
		private DispatchDetailStatus(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public int getId() {
			return this.id;
		}
		
		public String getName() {
			return this.name;
		}
	}
	
	/**
	 * 图表时间参数类型
	 */
	public enum DateParamType {
		ONEMONTH(1, "近一个月"), THREEMONTH(2, "近三个月"), ONEYEAR(3, "近一年"),THISMONTH(4, "当月"),THISYEAR(5, "当年");
		
		private int id;
		private String name;
		
		private DateParamType(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public int getId() {
			return this.id;
		}
		
		public String getName() {
			return this.name;
		}
	}
}
