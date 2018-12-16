
package prolab13;

public class seri implements manipRobot {

	private int motorsayisi;
	private double yukmiktari;
	private String robottipi;
	private double Hiz = 250.0;
	private int koluzunlugu = 156;
	private double tasiyacagiyukkap = 1000.0;

	public seri() {

	}

	public seri(int motorsayisi, double yukmiktari, String robottipi, double Hiz, int koluzunlugu,
			double tasiyacagiyukkap) {
		this.motorsayisi = motorsayisi;
		this.yukmiktari = yukmiktari;
		this.robottipi = robottipi;
		this.Hiz = Hiz;
		this.koluzunlugu = koluzunlugu;
		this.tasiyacagiyukkap = tasiyacagiyukkap;
	}

	public int getMotorsayisi() {
		return motorsayisi;
	}

	public void setMotorsayisi(int motorsayisi) {
		this.motorsayisi = motorsayisi;
	}

	public double getYukmiktari() {
		return yukmiktari;
	}

	public void setYukmiktari(double yukmiktari) {
		this.yukmiktari = yukmiktari;
	}

	public String getRobottipi() {
		return robottipi;
	}

	public void setRobottipi(String robottipi) {
		this.robottipi = robottipi;
	}

	public double gettasinmahizi() {

		return Hiz;
	}

	public void settasinmahizi(double Hiz) {
		this.Hiz = Hiz;
	}

	public int getKoluzunlugu() {
		return koluzunlugu;
	}

	public void setKoluzunlugu(int koluzunlugu) {
		this.koluzunlugu = koluzunlugu;
	}

	public double getTasiyacagiyukkap() {
		return tasiyacagiyukkap;
	}

	public void setTasiyacagiyukkap(double tasiyacagiyukkap) {
		this.tasiyacagiyukkap = tasiyacagiyukkap;
	}

}
