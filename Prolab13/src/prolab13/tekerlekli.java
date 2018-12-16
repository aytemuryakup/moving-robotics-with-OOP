
package prolab13;


public class tekerlekli implements gezginRobot{
	
	private int motorsayisi;
	private double yukmiktari;
	private String robottipi;
	private double Hiz = 500.0;
    private int tekerleksayisi;
    
    
    public tekerlekli(){
        
    }

    public tekerlekli(int tekerleksayisi,int motorsayisi, double yukmiktari, String robottipi, double hiz) {
        
        this.tekerleksayisi = tekerleksayisi;
        this.motorsayisi = motorsayisi;
        this.yukmiktari = yukmiktari;
        this.robottipi = robottipi;
        this.Hiz = hiz;
    }

    public int getTekerleksayisi() {
        return tekerleksayisi;
    }

    public void setTekerleksayisi(int tekerleksayisi) {
        this.tekerleksayisi = tekerleksayisi;
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

		this.yukmiktari = yukmiktari;
		
	}

	@Override
	public void setRobottipi(String robottipi) {
		
		this.robottipi = robottipi;
		
	}

	@Override
	public void setgezinmehizi(double hiz) {
		
		this.Hiz = hiz;
		
	}
	

    
    public double engeldengecmesuresibul()
    {
      return getMotorsayisi()*0.5;
    }
    
    
}
