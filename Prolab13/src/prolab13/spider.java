
package prolab13;

public class spider implements gezginRobot{
	
	private int motorsayisi;
	private double yukmiktari;
	private String robottipi;
	private double Hiz = 100.0;
    private int bacaksayisi;
    
    
    public spider(){
        
    }

    public spider(int bacaksayisi,int motorsayisi, double yukmiktari, String robottipi, double hiz) {
        
        this.bacaksayisi = bacaksayisi;
        this.motorsayisi = motorsayisi;
        this.yukmiktari = yukmiktari;
        this.robottipi = robottipi;
        this.Hiz = hiz;
    }
    
    

	public int getBacaksayisi() {
		return bacaksayisi;
	}

	public void setBacaksayisi(int bacaksayisi) {
		this.bacaksayisi = bacaksayisi;
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
	public void setgezinmehizi(double hiz) {
		// TODO Auto-generated method stub
		this.Hiz =hiz;
		
	}
    
    public int engeldengecmesuresibul()
    {
      return getMotorsayisi()*3;
    }
    
}

