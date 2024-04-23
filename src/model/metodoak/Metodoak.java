package model.metodoak;

public class Metodoak {
	public static String hezkuntzaKonprobatu(String hiz) {
		String hizkuntza = "";
		switch (hiz) {
		case "Euskera":
			hizkuntza = "EU";
			break;
		case "Español":
			hizkuntza = "ES";
			break;
		case "English":
			hizkuntza = "EN";
			break;
		case "Français":
			hizkuntza = "FR";
			break;
		case "Deutsch":
			hizkuntza = "DE";
			break;
		case "Catalá":
			hizkuntza = "CA";
			break;
		case "Gaeilg":
			hizkuntza = "GA";
			break;
		case "Arabic":
			hizkuntza = "AR";
			break;
		}
		return hizkuntza;
	}
}
