package com.jeff.vo;

import java.util.Comparator;

import com.jeff.po.PagePermit;

public class MenuVo {

	public String MENU_NAME;
	public String STATE;
	public String ICONCLS;
	public String MENU_URL;
	public String MENU_ID;
	public String PARENT_ID;

	public MenuVo(PagePermit pp) {
		this.MENU_NAME = pp.getName();
		this.STATE = "closed";
		this.ICONCLS = pp.getImage();
		this.MENU_URL = pp.getUrl();
		this.MENU_ID = pp.getId() + "";
		this.PARENT_ID = pp.getParentId() + "";
	}

	public MenuVo() {
		super();
	}

	public Comparator<MenuVo> comparator = new Comparator<MenuVo>() {
		public int compare(MenuVo s1, MenuVo s2) {
			return Integer.parseInt(s1.MENU_ID) - Integer.parseInt(s2.MENU_ID);
		}
	};

	public String getMENU_NAME() {
		return MENU_NAME;
	}

	public void setMENU_NAME(String mENU_NAME) {
		MENU_NAME = mENU_NAME;
	}

	public String getSTATE() {
		return STATE;
	}

	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}

	public String getICONCLS() {
		return ICONCLS;
	}

	public void setICONCLS(String iCONCLS) {
		ICONCLS = iCONCLS;
	}

	public String getMENU_URL() {
		return MENU_URL;
	}

	public void setMENU_URL(String mENU_URL) {
		MENU_URL = mENU_URL;
	}

	public String getMENU_ID() {
		return MENU_ID;
	}

	public void setMENU_ID(String mENU_ID) {
		MENU_ID = mENU_ID;
	}

	public String getPARENT_ID() {
		return PARENT_ID;
	}

	public void setPARENT_ID(String pARENT_ID) {
		PARENT_ID = pARENT_ID;
	}
}
