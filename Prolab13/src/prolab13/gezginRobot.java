
package prolab13;



public  interface gezginRobot extends robot{
    @Override
	int getMotorsayisi();
    @Override
	double getYukmiktari();
    @Override
	String getRobottipi();
    
    double getgezinmehizi();
    
    @Override
	void setMotorsayisi(int motor);
    @Override
	void setYukmiktari(double yukmiktari);
    @Override
	void setRobottipi (String robottipi);
    
    void setgezinmehizi(double hiz);
   
    
    
}
