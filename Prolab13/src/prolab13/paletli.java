
package prolab13;

public class paletli implements gezginRobot{
	
	private int motorsayisi;
	private double yukmiktari;
	private String robottipi;
	private double Hiz = 500.0;
    private int Paletsayisi;
    
    
    public paletli(){
        
    }

    public paletli(int paletsayisi,int motorsayisi, double yukmiktari, String robottipi, double hiz) {
        
        this.Paletsayisi = paletsayisi;
        this.motorsayisi = motorsayisi;
        this.yukmiktari = yukmiktari;
        this.robottipi = robottipi;
        this.Hiz = hiz;
    }
    
    
	public int getPaletsayisi() {
		return Paletsayisi;
	}

	public void setPaletsayisi(int paletsayisi) {
		Paletsayisi = paletsayisi;
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
	public double getgezinmehizi() {
		// TODO Auto-generated method stub
		return Hiz;
	}

	@Override
	public void setMotorsayisi(int motorsayisi) {
		
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
	public void setgezinmehizi(double hiz) {
		// TODO Auto-generated method stub
		this.Hiz = hiz;
		
	}
    
    public int engeldengecmesuresibul()
    {
      return getMotorsayisi()*3;
    }
    
}
