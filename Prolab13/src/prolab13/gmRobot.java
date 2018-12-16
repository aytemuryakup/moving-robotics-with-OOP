
package prolab13;



public class gmRobot  implements gezginRobot , manipRobot{
    
    private double sabitlemesuresi;
    private double tasinmahizi=100;
    private double gezinmehizi=250;
    private int koluzun = 200;
    private double tasyukkap;
    public int tekerleksayisi;
    public int bacaksayisi;
    public int paletsayisi;
    private int motorsayisi;
    private double yukmiktari=12;
    private String robottipi;
    
    
    public gmRobot() {
    	
    }
    
	
    public gmRobot(double sabitlemesuresi, double tasinmahizi, double gezinmehizi, int koluzun, double tasyukkap,
			int tekerleksayisi, int bacaksayisi, int paletsayisi, int motorsayisi, double yukmiktari,
			String robottipi) {
		
		this.sabitlemesuresi = sabitlemesuresi;
		this.tasinmahizi = tasinmahizi;
		this.gezinmehizi = gezinmehizi;
		this.koluzun = koluzun;
		this.tasyukkap = tasyukkap;
		this.tekerleksayisi = tekerleksayisi;
		this.bacaksayisi = bacaksayisi;
		this.paletsayisi = paletsayisi;
		this.motorsayisi = motorsayisi;
		this.yukmiktari = yukmiktari;
		this.robottipi = robottipi;
	}
    
    
    
    
	public double getSabitlemesuresi() {
		return sabitlemesuresi;
	}


	public void setSabitlemesuresi(double sabitlemesuresi) {
		this.sabitlemesuresi = sabitlemesuresi;
	}


	public int getTekerleksayisi() {
		return tekerleksayisi;
	}


	public void setTekerleksayisi(int tekerleksayisi) {
		this.tekerleksayisi = tekerleksayisi;
	}


	public int getBacaksayisi() {
		return bacaksayisi;
	}


	public void setBacaksayisi(int bacaksayisi) {
		this.bacaksayisi = bacaksayisi;
	}


	public int getPaletsayisi() {
		return paletsayisi;
	}


	public void setPaletsayisi(int paletsayisi) {
		this.paletsayisi = paletsayisi;
	}
	

    
    public double engeldengecmesuresibul()
    {
      return getMotorsayisi();
    }


	@Override
	public int getKoluzunlugu() {
		// TODO Auto-generated method stub
		return koluzun;
	}
	@Override
	public double getTasiyacagiyukkap() {
		// TODO Auto-generated method stub
		return tasyukkap;
	}
	@Override
	public void setKoluzunlugu(int koluzun) {
		// TODO Auto-generated method stub
		this.koluzun = koluzun;
		
	}
	@Override
	public void setTasiyacagiyukkap(double tasyukkap) {
		// TODO Auto-generated method stub
		this.tasyukkap = tasyukkap;
		
	}
	@Override
	public int getMotorsayisi() {
		// TODO Auto-generated method stub
		return motorsayisi;
	}
	@Override
	public double getYukmiktari() {
		// TODO Auto-generated method stub
		return yukmiktari;
	}
	@Override
	public String getRobottipi() {
		// TODO Auto-generated method stub
		return robottipi;
	}
	
	@Override
	public void setMotorsayisi(int motorsayisi) {
		// TODO Auto-generated method stub
		this.motorsayisi = motorsayisi;
		
	}
	@Override
	public void setYukmiktari(double yukmiktari) {
		// TODO Auto-generated method stub
		this.yukmiktari = yukmiktari;
		
	}
	@Override
	public void setRobottipi(String robottipi) {
		// TODO Auto-generated method stub
		this.robottipi = robottipi;
		
	}


	@Override
	public double gettasinmahizi() {
		// TODO Auto-generated method stub
		return tasinmahizi;
	}


	@Override
	public void settasinmahizi(double tasinmahizi) {
		// TODO Auto-generated method stub
		this.tasinmahizi = tasinmahizi;
		
	}


	@Override
	public double getgezinmehizi() {
		// TODO Auto-generated method stub
		return gezinmehizi;
	}


	@Override
	public void setgezinmehizi(double gezinmehizi) {
		// TODO Auto-generated method stub
		this.gezinmehizi = gezinmehizi;
		
	}
	
    
    
    
}
