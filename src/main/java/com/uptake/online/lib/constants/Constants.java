package com.uptake.online.lib.constants;


/**
 * File for all Enum constants with Types
 *
 * @author seetharam
 *
 */
public class Constants {
	
	public final static String windNavigationURL = "https://www.uptake.com/industries/wind";
	public final static String agricultureNavigationURL = "https://www.uptake.com/industries/agriculture";
	public final static String uptakeURL = "https://www.uptake.com";
	public final static String uptakeHeader = "UPTAKE";
	public final static String demoHeader = "REQUEST A PRODUCT DEMO";
	
	public static enum SiteHeaders {
		PRODUCTS("PRODUCTS"), INDUSTRIES("INDUSTRIES"), ABOUT("ABOUT"), EXPERTISE("EXPERTISE"), NEWS_INSIGHTS(
				"NEWS & INSIGHTS"), CAREERS("CAREERS"), CONTACT("CONTACT");
		public String value;

		SiteHeaders(String value) {
			this.value = value;
		}
	}

	public static enum IndustriesList {
		AGRICULTURE("AGRICULTURE"), AVIATION("AVIATION"), CONSTRUCTION("CONSTRUCTION"), ENERGY(
				"ENERGY"), EQUIPMENT_DEALERS("EQUIPMENT_DEALERS"), FLEET(
						"FLEET"), MINING("MINING"), OIL_AND_GAS("OIL AND GAS"), RAIL("RAIL"), WIND("WIND");
		public String value;

		IndustriesList(String value) {
			this.value = value;
		}
	}

	public static enum ExpertiseList {
		DATA_SCIENCE("DATA SCIENCE"), SECURITY("SECURITY");
		public String value;

		ExpertiseList(String value) {
			this.value = value;
		}
	}

}
