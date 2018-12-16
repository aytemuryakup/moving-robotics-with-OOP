
package prolab13;


public interface manipRobot extends robot{
    
  @Override
  int getMotorsayisi();
  @Override
  double getYukmiktari();
  @Override
  String getRobottipi();
  double gettasinmahizi();
  int getKoluzunlugu();
  double getTasiyacagiyukkap();
  

  @Override
  void setMotorsayisi(int motor);
  @Override
  void setYukmiktari(double yukmiktari);
  @Override
  void setRobottipi (String robottipi);
  void settasinmahizi (double hiz);
  void setKoluzunlugu(int koluzun);
  void setTasiyacagiyukkap(double tasyukkap);
    
}
