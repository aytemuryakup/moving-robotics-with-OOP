
package prolab13;

import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;

import prolab13.main.ButtonHandler;

import java.util.*;

public class main extends JFrame {

	private Container contents;

	private static JButton[][] squares = new JButton[20][20];

	private Color colorblack = Color.BLACK;
	int row = 0;
	int cells = 0;

	public void kullanici(int x, int y) {

		row = x;
		cells = y;
	}

	private static ImageIcon knight = new ImageIcon("/Users/muratduymaz/eclipse-workspace/orumcek.jpg");
	private static ImageIcon engel = new ImageIcon("/Users/muratduymaz/eclipse-workspace/engel.jpg");
	private static ImageIcon hedef = new ImageIcon("/Users/muratduymaz/eclipse-workspace/hedef.jpg");
	private static ImageIcon maniprobot = new ImageIcon("/Users/muratduymaz/eclipse-workspace/maniprobot.jpg");
	private static ImageIcon gezginmanip = new ImageIcon("/Users/muratduymaz/eclipse-workspace/gezginmanip.jpg");
	private static ImageIcon sabit = new ImageIcon("/Users/muratduymaz/eclipse-workspace/sabitnokta.jpg");
	private static ImageIcon yuk = new ImageIcon("/Users/muratduymaz/eclipse-workspace/yuk.jpg");

	public main() {

		super("Yakup Aytemur- Yusuf Zahid Üngör");

		contents = getContentPane();
		contents.setLayout(new GridLayout(20, 20));

		ButtonHandler buttonhandler = new ButtonHandler();

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				squares[i][j] = new JButton();

				contents.add(squares[i][j]);
				squares[i][j].addActionListener(buttonhandler);
			}
		}

		// squares[row][cells].setIcon(knight);

		setSize(800, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Object source = e.getSource();

			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {

					if (source == squares[i][j]) {
						return;
					}

				}
			}

		}

	}

	public static void main(String[] args) {

		int secim, robotsayisi;

		tekerlekli tk = new tekerlekli();
		paletli palet = new paletli();
		spider spd = new spider();
		seri sr = new seri();
		paralel pr = new paralel();
		gmRobot gm = new gmRobot();

		Scanner scan15 = new Scanner(System.in);
		System.out.println("Robot sayisi ");
		robotsayisi = scan15.nextInt();
		int k = 0;

		String[] robotbilgileri = new String[robotsayisi];

		for (int i = 0; i < robotsayisi; i++) {

			k++;

			System.out.println("Hangi robotda islem yapacaksaniz : ");
			System.out.println("1. Gezgin Robotlar");
			System.out.println("2. Manipulator Robotlar");
			System.out.println("3. Gezgin Manipulator Robotlar");

			Scanner scan = new Scanner(System.in);
			secim = scan.nextInt();

			// GEZGİN ROBOTLAR SEÇİMİ
			if (secim == 1) {
				int secim2;

				System.out.println("Islem yapmak istediginiz gezgin robotun tipini seciniz : ");
				System.out.println("1. Tekerlekli Robotlar");
				System.out.println("2. Paletli Robotlar");
				System.out.println("3. Spider Robotlar");

				Scanner scan3 = new Scanner(System.in);
				secim2 = scan3.nextInt();
				if (secim2 == 1) {
					Scanner scan2 = new Scanner(System.in);

					String robottipi;
					System.out.println("Robot tipini giriniz : ");
					robottipi = scan2.nextLine();
					tk.setRobottipi(robottipi);
					int motorsayisi;
					System.out.println("Motor sayisini giriniz : ");
					motorsayisi = scan2.nextInt();
					tk.setMotorsayisi(motorsayisi);
					int tekerleksayisi;
					System.out.println("Tekerlek sayisini giriniz : ");
					tekerleksayisi = scan2.nextInt();
					tk.setTekerleksayisi(tekerleksayisi);
					double yukmiktari;
					System.out.println("yuk Miktarini giriniz : ");
					yukmiktari = scan2.nextDouble();
					tk.setYukmiktari(yukmiktari);
					double hiz;
					System.out.println("Hizini giriniz : ");
					hiz = scan2.nextDouble();
					tk.setgezinmehizi(hiz);

					if (tk.getgezinmehizi() > palet.getgezinmehizi() && tk.getgezinmehizi() > spd.getgezinmehizi()) {

					} else if (tk.getgezinmehizi() > palet.getgezinmehizi()
							&& tk.getgezinmehizi() < spd.getgezinmehizi()) {
						System.out.println("Girinen Hiz Spider Robotun hizindan buyuk degildir.");
						System.out.println("Hizini tekrardan giriniz : ");
						hiz = scan2.nextDouble();
						tk.setgezinmehizi(hiz);
					} else if (tk.getgezinmehizi() < palet.getgezinmehizi()
							&& tk.getgezinmehizi() > spd.getgezinmehizi()) {
						System.out.println("Girinen Hiz Paletli Robotun hizindan buyuk degildir.");
						System.out.println("Hizini tekrardan giriniz : ");
						hiz = scan2.nextDouble();
						tk.setgezinmehizi(hiz);
					} else {
						System.out.println("Girinen Hiz Paletli ve Spider Robotun hizindan buyuk degildir.");
						System.out.println("Hizini tekrardan giriniz : ");
						hiz = scan2.nextDouble();
						tk.setgezinmehizi(hiz);
					}
					robotbilgileri[i] = k + ".robot :" + robottipi + " " + motorsayisi + " " + tekerleksayisi + " "
							+ yukmiktari + " " + hiz;

					System.out.println(k + "." + "robottipi : " + tk.getRobottipi() + "  motorsayisi : "
							+ tk.getMotorsayisi() + "  tekerlek sayisi : " + tk.getTekerleksayisi() + "  yük miktari : "
							+ tk.getYukmiktari() + "  hizi : " + tk.getgezinmehizi() + "\n ");

				}

				else if (secim2 == 2) {
					Scanner scan2 = new Scanner(System.in);

					String robottipi;
					System.out.println("Robot tipini giriniz : ");
					robottipi = scan2.nextLine();
					palet.setRobottipi(robottipi);
					int motorsayisi;
					System.out.println("Motor sayisini giriniz : ");
					motorsayisi = scan2.nextInt();
					palet.setMotorsayisi(motorsayisi);
					int paletsayisi;
					System.out.println("Tekerlek sayisini giriniz : ");
					paletsayisi = scan2.nextInt();
					palet.setPaletsayisi(paletsayisi);
					double yukmiktari;
					System.out.println("Yuk Miktarini giriniz : ");
					yukmiktari = scan2.nextDouble();
					palet.setYukmiktari(yukmiktari);
					double hiz;
					System.out.println("Hizini giriniz : ");
					hiz = scan2.nextDouble();
					palet.setgezinmehizi(hiz);
					;

					if (tk.getgezinmehizi() > palet.getgezinmehizi() && palet.getgezinmehizi() > spd.getgezinmehizi()) {
						System.out.println("Girinen Hiz dogrudur.");
					} else if (tk.getgezinmehizi() > palet.getgezinmehizi()
							&& palet.getgezinmehizi() < spd.getgezinmehizi()) {
						System.out.println("Girinen Hiz Spider Robotun hizindan buyuk degildir.");
						System.out.println("Hizini tekrardann giriniz : ");
						hiz = scan2.nextDouble();
						palet.setgezinmehizi(hiz);
					} else if (tk.getgezinmehizi() < palet.getgezinmehizi()
							&& palet.getgezinmehizi() < spd.getgezinmehizi()) {
						System.out.println("Girinen Hiz Tekerlekli Robotun hizindan buyuktur.");
						System.out.println("Lutfen Tekerlekli Robottan daha dusuk Hizda giriniz : ");
						hiz = scan2.nextDouble();
						palet.setgezinmehizi(hiz);
					}

					robotbilgileri[i] = k + ".robot :" + robottipi + " " + motorsayisi + " " + paletsayisi + " "
							+ yukmiktari + " " + hiz;

					System.out.println(k + "." + "robottipi : " + palet.getRobottipi() + "  motorsayisi : "
							+ palet.getMotorsayisi() + "  tekerlek sayisi : " + palet.getPaletsayisi()
							+ "  yuk miktari : " + palet.getYukmiktari() + "  hizi : " + palet.getgezinmehizi()
							+ "\n ");
				}

				else if (secim2 == 3) {
					Scanner scan2 = new Scanner(System.in);

					String robottipi;
					System.out.println("Robot tipini giriniz : ");
					robottipi = scan2.nextLine();
					spd.setRobottipi(robottipi);
					int motorsayisi;
					System.out.println("Motor sayisini giriniz : ");
					motorsayisi = scan2.nextInt();
					spd.setMotorsayisi(motorsayisi);
					int bacaksayisi;
					System.out.println("Bacak sayisini giriniz : ");
					bacaksayisi = scan2.nextInt();
					spd.setBacaksayisi(bacaksayisi);
					double yukmiktari;
					System.out.println("Yuk Miktarini giriniz : ");
					yukmiktari = scan2.nextDouble();
					spd.setYukmiktari(yukmiktari);
					double hiz;
					System.out.println("Hizini giriniz : ");
					hiz = scan2.nextDouble();
					spd.setgezinmehizi(hiz);

					if (tk.getgezinmehizi() > palet.getgezinmehizi() && palet.getgezinmehizi() > spd.getgezinmehizi()
							&& tk.getgezinmehizi() > spd.getgezinmehizi()) {

					} else if (spd.getgezinmehizi() > palet.getgezinmehizi()
							|| tk.getgezinmehizi() < spd.getgezinmehizi()) {
						System.out.println("Spider Robot en kucuk hiza sahipdir dogru degeri atayiniz.");
						System.out.println("Hizini tekrardann giriniz : ");
						hiz = scan2.nextDouble();
						spd.setgezinmehizi(hiz);
					}
					robotbilgileri[i] = k + ".robot :" + robottipi + " " + motorsayisi + " " + bacaksayisi + " "
							+ yukmiktari + " " + hiz;

					System.out.println(k + "." + "robottipi : " + spd.getRobottipi() + "  motorsayisi : "
							+ spd.getMotorsayisi() + "  bacak sayisi : " + spd.getBacaksayisi() + "  yuk miktari : "
							+ spd.getYukmiktari() + "  hizi : " + spd.getgezinmehizi()  + "\n ");

				}

			}
			// MAN�PULATOR ROBOT TANIMI
			if (secim == 2) {
				int secim2;

				System.out.println("Islem yapmak istediginiz manipulator robot tipini seciniz : ");
				System.out.println("1. Seri Robotlar");
				System.out.println("2. Paralel Robotlar");
				Scanner scan3 = new Scanner(System.in);
				secim2 = scan3.nextInt();
				if (secim2 == 1) {
					Scanner scan2 = new Scanner(System.in);

					String robottipi;
					System.out.println("Robot tipini giriniz : ");
					robottipi = scan2.nextLine();
					sr.setRobottipi(robottipi);
					int motorsayisi;
					System.out.println("Motor sayisini giriniz : ");
					motorsayisi = scan2.nextInt();
					sr.setMotorsayisi(motorsayisi);
					double tasimakapasitesi;
					System.out.println("Tasima Kapasitesini giriniz : ");
					tasimakapasitesi = scan2.nextDouble();
					sr.setTasiyacagiyukkap(tasimakapasitesi);
					if (sr.getTasiyacagiyukkap() < pr.getTasiyacagiyukkap()) {
						System.out.println("Tasima kapasitesi paralel robottan(" + pr.getTasiyacagiyukkap()
								+ ") buyuk olmaladir, lutfen tekrardan yuk kapasitesini giriniz  ");
						tasimakapasitesi = scan2.nextDouble();
						sr.setTasiyacagiyukkap(tasimakapasitesi);
					} else {
						System.out.println(
								"Tasima Kapasitesi istenen durumlardad�r deger girmeye devam edebilirsinz... \n");
					}
					double yukmiktari;
					System.out.println("Yuk Miktarini giriniz : ");
					yukmiktari = scan2.nextDouble();
					sr.setYukmiktari(yukmiktari);
					if (sr.getYukmiktari() > sr.getTasiyacagiyukkap()) {
						System.out.println("Yuk miktari seri robotun tasiyacagi(" + sr.getTasiyacagiyukkap()
								+ ") yuk kapasitesinden buyuk olamaz, lutfen tekrardan yuk miktari giriniz  ");
						yukmiktari = scan2.nextDouble();
						sr.setYukmiktari(yukmiktari);
					} else {
						System.out.println("Yuk miktari istenen durumlardad�r deger girmeye devam edebilirsinz... \n");
					}
					double hiz;
					System.out.println("Hizini giriniz : ");
					hiz = scan2.nextDouble();
					sr.settasinmahizi(hiz);
					if (sr.gettasinmahizi() > pr.gettasinmahizi()) {
						System.out.println("Hiziniz paralel robottan buyuk olamaz Lutfen tekrardan hiz giriniz : ");
						hiz = scan2.nextDouble();
						sr.settasinmahizi(hiz);
					} else {
						System.out.println("Hiziniz paralel robottan kucuktur veri almaya devam edebilirsiniz... ");
					}

					int koluzunlugu;
					System.out.println("Kol uzunlugunu giriniz : ");
					koluzunlugu = scan2.nextInt();
					sr.setKoluzunlugu(koluzunlugu);

					robotbilgileri[i] = k + ".robot :" + robottipi + " " + motorsayisi + " " + yukmiktari + " " + hiz
							+ " " + tasimakapasitesi + " " + koluzunlugu;
					System.out.println(k + "." + "robottipi : " + sr.getRobottipi() + "  motorsayisi : "
							+ sr.getMotorsayisi() + "  yuk miktari : " + sr.getYukmiktari() + "  hizi : "
							+ sr.gettasinmahizi() + " tasima kapasitesi : " + sr.getTasiyacagiyukkap()
							+ " koluzunlugu : " + sr.getKoluzunlugu() + "\n ");
				}

				else if (secim2 == 2) {
					Scanner scan2 = new Scanner(System.in);

					String robottipi;
					System.out.println("Robot tipini giriniz : ");
					robottipi = scan2.nextLine();
					pr.setRobottipi(robottipi);
					int motorsayisi;
					System.out.println("Motor sayisini giriniz : ");
					motorsayisi = scan2.nextInt();
					pr.setMotorsayisi(motorsayisi);
					double tasimakapasitesi;
					System.out.println("Tasima Kapasitesini giriniz : ");
					tasimakapasitesi = scan2.nextDouble();
					pr.setTasiyacagiyukkap(tasimakapasitesi);
					if (sr.getTasiyacagiyukkap() < pr.getTasiyacagiyukkap()) {
						System.out.println("Tasima kapasitesi seri robottan(" + sr.getTasiyacagiyukkap()
								+ ")kucuk olmaladir, lutfen tekrardan yuk kapasitesini giriniz  ");
						tasimakapasitesi = scan2.nextDouble();
						pr.setTasiyacagiyukkap(tasimakapasitesi);
					} else {
						System.out.println(
								"Tasima Kapasitesi istenen durumlardad�r deger girmeye devam edebilirsinz... \n");
					}
					double yukmiktari;
					System.out.println("Yuk Miktarini giriniz : ");
					yukmiktari = scan2.nextDouble();
					pr.setYukmiktari(yukmiktari);
					if (pr.getYukmiktari() > pr.getTasiyacagiyukkap()) {
						System.out.println("Yuk miktari paralel robotun tasiyacagi(" + pr.getTasiyacagiyukkap()
								+ ") yuk kapasitesinden buyuk olamaz, lutfen tekrardan yuk miktari giriniz  ");
						yukmiktari = scan2.nextDouble();
						pr.setYukmiktari(yukmiktari);
					} else {
						System.out.println("Yuk miktari istenen durumlardad�r deger girmeye devam edebilirsinz... \n");
					}
					double hiz;
					System.out.println("Hizini giriniz : ");
					hiz = scan2.nextDouble();
					pr.settasinmahizi(hiz);

					if (sr.gettasinmahizi() > pr.gettasinmahizi()) {
						System.out.println("Hiziniz seri robottan kucuk olamaz Lutfen tekrardan hiz giriniz : ");
						hiz = scan2.nextDouble();
						pr.settasinmahizi(hiz);
					} else {
						System.out.println("Hiziniz seri robottan buyuktur veri almaya devam edebilirsiniz... \n");
					}

					int koluzunlugu;
					System.out.println("Kol uzunlugunu giriniz : ");
					koluzunlugu = scan2.nextInt();
					pr.setKoluzunlugu(koluzunlugu);
					robotbilgileri[i] = k + ".robot :" + robottipi + " " + motorsayisi + " " + yukmiktari + " " + hiz
							+ " " + tasimakapasitesi + " " + koluzunlugu;
					System.out.println(k + "." + "robottipi : " + pr.getRobottipi() + "  motorsayisi : "
							+ pr.getMotorsayisi() + "  yuk miktari : " + pr.getYukmiktari() + "  hizi : "
							+ pr.gettasinmahizi() + " tasima kapasitesi : " + pr.getTasiyacagiyukkap()
							+ " koluzunlugu : " + pr.getKoluzunlugu() + "\n ");
				}

			}

			// GEZGIN MANIPULATOR ROBOT

			if (secim == 3) {

				int secim6;
				Scanner scan6 = new Scanner(System.in);
				System.out.println("Hibrit Robotun Gezgin robot gibi davranan kismi icin secim yapınız : ");
				System.out.println("1. Tekerlekli Robotlar");
				System.out.println("2. Paletli Robotlar");
				System.out.println("3. Spider Robotlar");
				secim6 = scan6.nextInt();

				if (secim6 == 1) {

					Scanner scan2 = new Scanner(System.in);
					int motorsayisi;
					System.out.println("Motor sayisini giriniz : ");
					motorsayisi = scan2.nextInt();
					gm.setMotorsayisi(motorsayisi);
					int tekerleksayisi;
					System.out.println("Tekerlek sayisini giriniz : ");
					tekerleksayisi = scan2.nextInt();
					gm.setTekerleksayisi(tekerleksayisi);
					double yukmiktari;
					System.out.println("yuk Miktarini giriniz : ");
					yukmiktari = scan2.nextDouble();
					gm.setYukmiktari(yukmiktari);
					double hiz;
					System.out.println("Hizini giriniz : ");
					hiz = scan2.nextDouble();
					gm.setgezinmehizi(hiz);

					int secim7;
					Scanner scan7 = new Scanner(System.in);
					System.out.println("Hibrit Robotun Manipülatör robot gibi davranan kismi icin secim yapınız : ");
					System.out.println("1. Seri Robotlar");
					System.out.println("2. Paralel Robotlar");
					secim7 = scan7.nextInt();

					if (secim7 == 1) {

						Scanner scan22 = new Scanner(System.in);
						String robottipi1;
						System.out.println("Robot tipini giriniz : ");
						robottipi1 = scan22.nextLine();
						gm.setRobottipi(robottipi1);
						double tasimakapasitesi1;
						System.out.println("Tasima Kapasitesini giriniz : ");
						tasimakapasitesi1 = scan22.nextDouble();
						gm.setTasiyacagiyukkap(tasimakapasitesi1);

						if (gm.getYukmiktari() > gm.getTasiyacagiyukkap()) {
							System.out.println("Tasima kapasitesi (" + gm.getYukmiktari()
									+ ") yuk miktariından kucuk olamaz, lutfen tekrardan tasima giriniz  ");
							tasimakapasitesi1 = scan22.nextDouble();
							gm.setTasiyacagiyukkap(tasimakapasitesi1);

						} else {
							System.out.println(
									"Yuk miktari istenen durumlardadir deger girmeye devam edebilirsinz... \n");
						}
						double hiz1;
						System.out.println("Hizini giriniz : ");
						hiz1 = scan22.nextDouble();
						gm.settasinmahizi(hiz1);

						if (gm.gettasinmahizi() > gm.getgezinmehizi()) {
							System.out.println(
									"Hiziniz robotun gezgin kısmından buyuk olamaz ("+gm.getgezinmehizi()+") Lutfen tekrardan hiz giriniz : ");
							hiz1 = scan22.nextDouble();
							gm.settasinmahizi(hiz1);
						} else {
							System.out.println("Hiziniz robotun gezinme hizindan kucuktur veri almaya devam edebilirsiniz... \n");
						}

						double sabitlenmesuresi;
						System.out.println("Sabitlenme Suresini giriniz : ");
						sabitlenmesuresi = scan22.nextDouble();
						gm.setSabitlemesuresi(sabitlenmesuresi);

						int koluzunlugu1;
						System.out.println("Kol uzunlugunu giriniz : ");
						koluzunlugu1 = scan22.nextInt();
						gm.setKoluzunlugu(koluzunlugu1);
						robotbilgileri[i] = (k) + ".kısım :" + robottipi1 + " motorsayisi " + motorsayisi + " yukmiktari " + yukmiktari + " gezinmehizi "
								+ hiz + " tekerleksayisi " + tekerleksayisi + " " + (k + 1) + ".kısım : " + robottipi1 + "  motorsayisi"
								+ motorsayisi + " yukmiktari " + yukmiktari + " tasinmahizi " + hiz1 + " kapasite " + tasimakapasitesi1 + " koluzun "
								+ koluzunlugu1;
						System.out.println(k + ". kısım " + " robottipi : " + gm.getRobottipi() + "  motorsayisi : "
								+ gm.getMotorsayisi() + " tekerleksayisi : " + gm.getTekerleksayisi()
								+ "  yuk miktari : " + gm.getYukmiktari() + "  gezinmehizi : " + gm.getgezinmehizi()
								+ "    " + (k + 1) + " . kısım  " + "  robottipi : " + gm.getRobottipi()
								+ "  motorsayisi : " + gm.getMotorsayisi() + "  yuk miktari : " + gm.getYukmiktari()
								+ "  tasinmahizi : " + gm.gettasinmahizi() + " tasima kapasitesi : "
								+ gm.getTasiyacagiyukkap() + " koluzunlugu : " + gm.getKoluzunlugu()
								+ " sabitlenme suresi : " + gm.getSabitlemesuresi() + "\n ");

					} else {

						Scanner scan23 = new Scanner(System.in);
						String robottipi1;
						System.out.println("Robot tipini giriniz : ");
						robottipi1 = scan23.nextLine();
						gm.setRobottipi(robottipi1);

						double tasimakapasitesi1;
						System.out.println("Tasima Kapasitesini giriniz : ");
						tasimakapasitesi1 = scan23.nextDouble();
						gm.setTasiyacagiyukkap(tasimakapasitesi1);

						if (gm.getYukmiktari() > gm.getTasiyacagiyukkap()) {
							System.out.println("Tasima kapasitesi (" + gm.getYukmiktari()
									+ ") yuk miktariından kucuk olamaz, lutfen tekrardan tasima giriniz  ");
							tasimakapasitesi1 = scan23.nextDouble();
							gm.setTasiyacagiyukkap(tasimakapasitesi1);

						} else {
							System.out.println(
									"Tasima Kapasitesi miktari istenen durumlardadir deger girmeye devam edebilirsinz... \n");
						}
						double hiz1;
						System.out.println("Hizini giriniz : ");
						hiz1 = scan23.nextDouble();
						gm.settasinmahizi(hiz1);

						if (gm.gettasinmahizi() > gm.getgezinmehizi()) {
							System.out.println(
									"Hiziniz robotun gezgin kısmından buyuk olamaz ("+gm.getgezinmehizi()+") Lutfen tekrardan hiz giriniz : ");
							hiz1 = scan23.nextDouble();
							gm.settasinmahizi(hiz1);
						} else {
							System.out.println(
									"Hiziniz robotun gezinme hizindan kucuktur veri almaya devam edebilirsiniz... \n");
						}

						double sabitlenmesuresi;
						System.out.println("Sabitlenme Suresini giriniz : ");
						sabitlenmesuresi = scan23.nextDouble();
						gm.setSabitlemesuresi(sabitlenmesuresi);

						int koluzunlugu1;
						System.out.println("Kol uzunlugunu giriniz : ");
						koluzunlugu1 = scan23.nextInt();
						gm.setKoluzunlugu(koluzunlugu1);
						robotbilgileri[i] = (k) + ".kısım :" + robottipi1 + " motorsayisi " + motorsayisi + " yukmiktari " + yukmiktari + "  gezinmehizi "
								+ hiz + " tekerleksayisi " + tekerleksayisi + " " + (k + 1) + ".kısım :" + robottipi1 + " motorsayisi "
								+ motorsayisi + " yukmiktari " + yukmiktari + " tasinmahizi " + hiz1 + " kapasite " + tasimakapasitesi1 + " koluzun "
								+ koluzunlugu1;
						System.out.println(k + ". kısım " + "robottipi : " + gm.getRobottipi() + "  motorsayisi : "
								+ +gm.getMotorsayisi() + " tekerleksayisi : " + gm.getTekerleksayisi()
								+ "  yuk miktari : " + gm.getYukmiktari() + "  gezinmehizi : " + gm.getgezinmehizi()
								+ "    " + (k + 1) + ". kısım " + " robottipi : " + gm.getRobottipi()
								+ "  motorsayisi : " + gm.getMotorsayisi() + "  yuk miktari : " + gm.getYukmiktari()
								+ "  tasinmahizi : " + gm.gettasinmahizi() + " tasima kapasitesi : "
								+ gm.getTasiyacagiyukkap() + " koluzunlugu : " + gm.getKoluzunlugu()
								+ " sabitlenme suresi : " + gm.getSabitlemesuresi() + "\n ");

					}

				}

				if (secim6 == 2) {

					Scanner scan2 = new Scanner(System.in);
					int motorsayisi;
					System.out.println("Motor sayisini giriniz : ");
					motorsayisi = scan2.nextInt();
					gm.setMotorsayisi(motorsayisi);
					int paletsayisi;
					System.out.println("Palet sayisini giriniz : ");
					paletsayisi = scan2.nextInt();
					gm.setPaletsayisi(paletsayisi);
					double yukmiktari;
					System.out.println("yuk Miktarini giriniz : ");
					yukmiktari = scan2.nextDouble();
					gm.setYukmiktari(yukmiktari);
					double hiz;
					System.out.println("Hizini giriniz : ");
					hiz = scan2.nextDouble();
					gm.setgezinmehizi(hiz);

					int secim7;
					Scanner scan7 = new Scanner(System.in);
					System.out.println("Hibrit Robotun Manipülatör robot gibi davranan kismi icin secim yapınız : ");
					System.out.println("1. Seri Robotlar");
					System.out.println("2. Paralel Robotlar");
					secim7 = scan7.nextInt();

					if (secim7 == 1) {

						Scanner scan22 = new Scanner(System.in);
						String robottipi1;
						System.out.println("Robot tipini giriniz : ");
						robottipi1 = scan22.nextLine();
						gm.setRobottipi(robottipi1);
						double tasimakapasitesi1;
						System.out.println("Tasima Kapasitesini giriniz : ");
						tasimakapasitesi1 = scan22.nextDouble();
						gm.setTasiyacagiyukkap(tasimakapasitesi1);

						if (gm.getYukmiktari() > gm.getTasiyacagiyukkap()) {
							System.out.println("Tasima kapasitesi (" + gm.getYukmiktari()
									+ ") yuk miktariından kucuk olamaz, lutfen tekrardan tasima giriniz  ");
							tasimakapasitesi1 = scan22.nextDouble();
							gm.setTasiyacagiyukkap(tasimakapasitesi1);

						} else {
							System.out.println(
									"Yuk miktari istenen durumlardadir deger girmeye devam edebilirsinz... \n");
						}
						double hiz1;
						System.out.println("Hizini giriniz : ");
						hiz1 = scan22.nextDouble();
						gm.settasinmahizi(hiz1);

						if (gm.gettasinmahizi() > gm.getgezinmehizi()) {
							System.out.println(
									"Hiziniz robotun gezgin kısmından buyuk olamaz ("+gm.getgezinmehizi()+") Lutfen tekrardan hiz giriniz : ");
							hiz1 = scan22.nextDouble();
							gm.settasinmahizi(hiz1);
						} else {
							System.out.println("Hiziniz robotun gezinme hızından kucuktur veri almaya devam edebilirsiniz... \n");
						}

						double sabitlenmesuresi;
						System.out.println("Sabitlenme Suresini giriniz :  ");
						sabitlenmesuresi = scan22.nextDouble();
						gm.setSabitlemesuresi(sabitlenmesuresi);

						int koluzunlugu1;
						System.out.println("Kol uzunlugunu giriniz : ");
						koluzunlugu1 = scan22.nextInt();
						gm.setKoluzunlugu(koluzunlugu1);
						robotbilgileri[i] = (k) + ".kısım :" + robottipi1 + " motorsayisi " + motorsayisi + " yukmiktari " + yukmiktari + " gezinmehizi "
								+ hiz + " paletsayisi " + paletsayisi + " " + (k + 1) + ".kısım :" + robottipi1 + " motorsayisi " + motorsayisi
								+ " yukmiktari " + yukmiktari + " tasinmahizi " + hiz1 + " kapasite " + tasimakapasitesi1 + " kol" + koluzunlugu1;
						System.out.println(k + ". kısım " + " robottipi : " + gm.getRobottipi() + "  motorsayisi : "
								+ +gm.getMotorsayisi() + " paletsayisi : " + gm.getPaletsayisi() + "  yuk miktari : "
								+ gm.getYukmiktari() + "  gezinmehizi : " + gm.getgezinmehizi() + "    " + (k + 1)
								+ " . kısım " + " robottipi : " + gm.getRobottipi() + "  motorsayisi : "
								+ gm.getMotorsayisi() + "  yuk miktari : " + gm.getYukmiktari() + "  tasinmahizi : "
								+ gm.gettasinmahizi() + " tasima kapasitesi : " + gm.getTasiyacagiyukkap()
								+ " koluzunlugu : " + gm.getKoluzunlugu() + " sabitlenme suresi : "
								+ gm.getSabitlemesuresi() + "\n ");

					} else {

						Scanner scan23 = new Scanner(System.in);
						String robottipi1;
						System.out.println("Robot tipini giriniz : ");
						robottipi1 = scan23.nextLine();
						gm.setRobottipi(robottipi1);

						double tasimakapasitesi1;
						System.out.println("Tasima Kapasitesini giriniz : ");
						tasimakapasitesi1 = scan23.nextDouble();
						gm.setTasiyacagiyukkap(tasimakapasitesi1);

						if (gm.getYukmiktari() > gm.getTasiyacagiyukkap()) {
							System.out.println("Tasima kapasitesi (" + gm.getYukmiktari()
									+ ") yuk miktariından kucuk olamaz, lutfen tekrardan tasima giriniz  ");
							tasimakapasitesi1 = scan23.nextDouble();
							gm.setTasiyacagiyukkap(tasimakapasitesi1);

						} else {
							System.out.println(
									"Tasima Kapasitesi miktari istenen durumlardadir deger girmeye devam edebilirsinz... \n");
						}
						double hiz1;
						System.out.println("Hizini giriniz : ");
						hiz1 = scan23.nextDouble();
						gm.settasinmahizi(hiz1);

						if (gm.gettasinmahizi() > gm.getgezinmehizi()) {
							System.out.println(
									"Hiziniz robotun gezgin kısmından buyuk olamaz ("+gm.getgezinmehizi()+") Lutfen tekrardan hiz giriniz : ");
							hiz1 = scan23.nextDouble();
							gm.settasinmahizi(hiz1);
						} else {
							System.out.println(
									"Hiziniz robotun gezinme kısmından kucuktur veri almaya devam edebilirsiniz... \n");
						}

						double sabitlenmesuresi;
						System.out.println("Sabitlenme Suresini giriniz : ");
						sabitlenmesuresi = scan23.nextDouble();
						gm.setSabitlemesuresi(sabitlenmesuresi);

						int koluzunlugu1;
						System.out.println("Kol uzunlugunu giriniz : ");
						koluzunlugu1 = scan23.nextInt();
						gm.setKoluzunlugu(koluzunlugu1);
						robotbilgileri[i] = (k) + ".kısım :" + robottipi1 + " motorsayisi " + motorsayisi
								+ " yukmiktari " + yukmiktari + " gezinmehiz " + hiz + " paletsayisi " + paletsayisi + " " + (k + 1)
								+ ".kısım :" + robottipi1 + "motorsayisi " + motorsayisi + " yukmiktari " + yukmiktari
								+ " tasinmahizi " + hiz1 + " tasimakapasitesi" + tasimakapasitesi1 + " koluzunlugu " + koluzunlugu1;
						System.out.println(k + ". kısım " + "robottipi : " + gm.getRobottipi() + "  motorsayisi : "
								+ gm.getMotorsayisi() + " paletsayisi : " + gm.getPaletsayisi() + "  yuk miktari : "
								+ gm.getYukmiktari() + "  gezinmehizi : " + gm.getgezinmehizi() + "    " + (k + 1)
								+ ". kısım " + " robottipi : " + gm.getRobottipi() + "  motorsayisi : "
								+ gm.getMotorsayisi() + "  yuk miktari : " + gm.getYukmiktari() + "  tasinmahizi : "
								+ gm.gettasinmahizi() + " tasima kapasitesi : " + gm.getTasiyacagiyukkap()
								+ " koluzunlugu : " + gm.getKoluzunlugu() + " sabitlenme suresi : "
								+ gm.getSabitlemesuresi() + "\n ");

					}

				}

				if (secim6 == 3) {

					Scanner scan2 = new Scanner(System.in);
					int motorsayisi;
					System.out.println("Motor sayisini giriniz : ");
					motorsayisi = scan2.nextInt();
					gm.setMotorsayisi(motorsayisi);
					int bacaksayisi;
					System.out.println("Palet sayisini giriniz : ");
					bacaksayisi = scan2.nextInt();
					gm.setBacaksayisi(bacaksayisi);
					double yukmiktari;
					System.out.println("yuk Miktarini giriniz : ");
					yukmiktari = scan2.nextDouble();
					gm.setYukmiktari(yukmiktari);
					double hiz;
					System.out.println("Hizini giriniz : ");
					hiz = scan2.nextDouble();
					gm.setgezinmehizi(hiz);

					int secim7;
					Scanner scan7 = new Scanner(System.in);
					System.out.println("Hibrit Robotun Manipülatör robot gibi davranan kismi icin secim yapınız : ");
					System.out.println("1. Seri Robotlar");
					System.out.println("2. Paralel Robotlar");
					secim7 = scan7.nextInt();

					if (secim7 == 1) {

						Scanner scan22 = new Scanner(System.in);
						String robottipi1;
						System.out.println("Robot tipini giriniz : ");
						robottipi1 = scan22.nextLine();
						gm.setRobottipi(robottipi1);
						double tasimakapasitesi1;
						System.out.println("Tasima Kapasitesini giriniz : ");
						tasimakapasitesi1 = scan22.nextDouble();
						gm.setTasiyacagiyukkap(tasimakapasitesi1);

						if (gm.getYukmiktari() > gm.getTasiyacagiyukkap()) {
							System.out.println("Tasima kapasitesi (" + gm.getYukmiktari()
									+ ") yuk miktariından kucuk olamaz, lutfen tekrardan tasima giriniz  ");
							tasimakapasitesi1 = scan22.nextDouble();
							gm.setTasiyacagiyukkap(tasimakapasitesi1);

						} else {
							System.out.println(
									"Yuk miktari istenen durumlardadir deger girmeye devam edebilirsinz... \n");
						}
						double hiz1;
						System.out.println("Hizini giriniz : ");
						hiz1 = scan22.nextDouble();
						gm.settasinmahizi(hiz1);

						if (gm.gettasinmahizi() > gm.getgezinmehizi()) {
							System.out.println(
									"Hiziniz robotun gezgin kısmından buyuk olamaz ("+gm.gettasinmahizi()+") Lutfen tekrardan hiz giriniz : ");
							hiz1 = scan22.nextDouble();
							gm.settasinmahizi(hiz1);
						} else {
							System.out.println("Hiziniz  robotun gezgin kısmından kucuktur veri almaya devam edebilirsiniz... \n");
						}

						double sabitlenmesuresi;
						System.out.println("Sabitlenme Suresini giriniz : ");
						sabitlenmesuresi = scan22.nextDouble();
						gm.setSabitlemesuresi(sabitlenmesuresi);

						int koluzunlugu1;
						System.out.println("Kol uzunlugunu giriniz : ");
						koluzunlugu1 = scan22.nextInt();
						gm.setKoluzunlugu(koluzunlugu1);
						robotbilgileri[i] = (k) + ".kısım : " + robottipi1 + " motorsayisi " + motorsayisi + " yukmiktari " + yukmiktari + "  gezinmehizi"
								+ hiz + " bacaksayisi " + bacaksayisi + "  " + (k + 1) + ".kısım : " + robottipi1 + " motorsayisi " + motorsayisi
								+ " yukmiktari " + yukmiktari + " tasimahizi " + hiz1 + " tasimakapasitesi " + tasimakapasitesi1 + " koluzunlugu " + koluzunlugu1;
						System.out.println(k + ". kısım " + " robottipi : " + gm.getRobottipi() + "  motorsayisi : "
								+ +gm.getMotorsayisi() + " paletsayisi : " + gm.getBacaksayisi() + "  yuk miktari : "
								+ gm.getYukmiktari() + "  gezinmehizi : " + gm.getgezinmehizi() + "    " + (k + 1)
								+ " . kısım " + " robottipi : " + gm.getRobottipi() + "  motorsayisi : "
								+ gm.getMotorsayisi() + "  yuk miktari : " + gm.getYukmiktari() + "  tasinmahizi : "
								+ gm.gettasinmahizi() + " tasima kapasitesi : " + gm.getTasiyacagiyukkap()
								+ " koluzunlugu : " + gm.getKoluzunlugu() + " sabitlenme suresi : "
								+ gm.getSabitlemesuresi() + "\n ");

					} else {

						Scanner scan23 = new Scanner(System.in);
						String robottipi1;
						System.out.println("Robot tipini giriniz : ");
						robottipi1 = scan23.nextLine();
						gm.setRobottipi(robottipi1);

						double tasimakapasitesi1;
						System.out.println("Tasima Kapasitesini giriniz : ");
						tasimakapasitesi1 = scan23.nextDouble();
						gm.setTasiyacagiyukkap(tasimakapasitesi1);

						if (gm.getYukmiktari() > gm.getTasiyacagiyukkap()) {
							System.out.println("Tasima kapasitesi (" + gm.getYukmiktari()
									+ ") yuk miktariından kucuk olamaz, lutfen tekrardan tasima giriniz  ");
							tasimakapasitesi1 = scan23.nextDouble();
							gm.setTasiyacagiyukkap(tasimakapasitesi1);

						} else {
							System.out.println(
									"Tasima Kapasitesi miktari istenen durumlardadir deger girmeye devam edebilirsinz... \n");
						}
						double hiz1;
						System.out.println("Hizini giriniz : ");
						hiz1 = scan23.nextDouble();
						gm.settasinmahizi(hiz1);

						if (gm.gettasinmahizi() > gm.getgezinmehizi()) {
							System.out.println(
									"Hiziniz robotun gezgin kısmından buyuk olamaz ("+gm.gettasinmahizi()+") Lutfen tekrardan hiz giriniz : ");
							hiz1 = scan23.nextDouble();
							gm.settasinmahizi(hiz1);
						} else {
							System.out.println(
									"Hiziniz robotun gezgin kısmından kucuktur veri almaya devam edebilirsiniz... \n");
						}

						double sabitlenmesuresi;
						System.out.println("Sabitlenme Suresini giriniz : ");
						sabitlenmesuresi = scan23.nextDouble();
						gm.setSabitlemesuresi(sabitlenmesuresi);

						int koluzunlugu1;
						System.out.println("Kol uzunlugunu giriniz : ");
						koluzunlugu1 = scan23.nextInt();
						gm.setKoluzunlugu(koluzunlugu1);
						robotbilgileri[i] = (k) + ".kısım :" + robottipi1 + " motorsayisi " + motorsayisi
								+ " yukmiktari " + yukmiktari + " gezinmehiz " + hiz + " " + bacaksayisi + " " + (k + 1)
								+ ".kısım :" + robottipi1 + "motorsayisi " + motorsayisi + " yukmiktari " + yukmiktari
								+ " tasinmahizi " + hiz1 + " tasima kapasitesi " + tasimakapasitesi1 + " koluzunlugu " + koluzunlugu1;
						System.out.println(k + ". kısım " + "robottipi : " + gm.getRobottipi() + "  motorsayisi : "
								+ gm.getMotorsayisi() + " bacaksayisi : " + gm.getBacaksayisi() + "  yuk miktari : "
								+ gm.getYukmiktari() + "  gezinmehizi : " + gm.getgezinmehizi() + "    " + (k + 1)
								+ ". kısım " + " robottipi : " + gm.getRobottipi() + "  motorsayisi : "
								+ gm.getMotorsayisi() + "  yuk miktari : " + gm.getYukmiktari() + "  tasinmahizi : "
								+ gm.gettasinmahizi() + " tasima kapasitesi : " + gm.getTasiyacagiyukkap()
								+ " koluzunlugu : " + gm.getKoluzunlugu() + " sabitlenme suresi : "
								+ gm.getSabitlemesuresi() + "\n ");

					}

				}

			}

		}

		// HANGI ROBOTU SECEGEM�Z YER
		Scanner scan26 = new Scanner(System.in);
		int secmedegeri;
		System.out.println("Hangi Robotu Grafikte g�stereceksiniz : ");
		secmedegeri = scan26.nextInt();
		int scmsayisi = 0;
		for (int j = 0; j < secmedegeri; j++) {
			scmsayisi++;

			if (secmedegeri == scmsayisi) {
				if (robotbilgileri[secmedegeri - 1].contains("tekerlekli")) {
					System.out.println(robotbilgileri[secmedegeri - 1]);
					String[] parse = robotbilgileri[secmedegeri - 1].split(" ");

					// TEKERLEKLİ GRAFİK KISMI

					main gr = new main();
					gr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					int a, b, c, d, e, f, g, h, engelx = 0, engely = 0, hedefx, hedefy, kacengel, gecme_sayisi = 0;

					Scanner scan = new Scanner(System.in);
					System.out.println("Başlangıç X konumu  : ");
					a = scan.nextInt();
					Scanner scan2 = new Scanner(System.in);
					System.out.println("Başlangıç Y konumu  : ");
					b = scan2.nextInt();
					gr.kullanici(a, b);
					squares[a - 1][b - 1].setIcon(knight);

					Scanner scan95 = new Scanner(System.in);
					System.out.println("Hedef X konumu  : ");
					hedefx = scan95.nextInt();
					Scanner scan99 = new Scanner(System.in);
					System.out.println("Hedef Y konumu  : ");
					hedefy = scan99.nextInt();
					gr.kullanici(hedefx, hedefy);
					squares[hedefx - 1][hedefy - 1].setIcon(hedef);

					Scanner scan75 = new Scanner(System.in);
					System.out.println("Kaç Engel Girmek istersiniz : ");
					kacengel = scan75.nextInt();
					int[] engel_diziy = new int[kacengel];
					int[] engel_dizix = new int[kacengel];

					for (int i = 0; i < kacengel; i++) {
						Scanner scan34 = new Scanner(System.in);
						System.out.println("Engel X konumu  : ");
						engelx = scan34.nextInt();
						Scanner scan35 = new Scanner(System.in);
						System.out.println("Engel Y konumu  : ");
						engely = scan35.nextInt();
						engel_diziy[i] = engely;
						engel_dizix[i] = engelx;
						gr.kullanici(engelx, engely);
						squares[engelx - 1][engely - 1].setIcon(engel);
					}

					Scanner scan3 = new Scanner(System.in);
					System.out.println("Sağa doğru kaç birim gidicek : ");
					c = scan3.nextInt();
					if (b + c > 20) {
						System.out.println("SOn konum ");
						squares[a - 1][19].setIcon(knight);
						System.out.println("gecme sayisi " + gecme_sayisi);

					}

					else if (b - 1 + c < 20) {

						for (int i = 0; i < kacengel; i++) {

							if ((b + c == engel_diziy[i] || b + c >= engel_diziy[i]) && b < engel_diziy[i]
									&& a == engel_dizix[i]) {
								System.out.println((i + 1) + ".engeli x ekseninde " + ((b - 1 + c) - engel_diziy[i])
										+ " birim geçtiniz ");
								gecme_sayisi += 1;

							}

							else {

							}

						}

						Scanner scan5 = new Scanner(System.in);
						System.out.println("Sola doğru kaç birim gidicek : ");
						d = scan5.nextInt();

						if (b - d + c < 1) {
							System.out.println("Son konum : ");
							squares[a - 1][0].setIcon(knight);

						}

						else if (b - d + c >= 1) {

							for (int i = 0; i < kacengel; i++) {
								if ((b + c - d == engel_diziy[i] || b + c - d <= engel_diziy[i])
										&& (b < engel_diziy[i] || b > engel_diziy[i]) && a == engel_dizix[i]) {
									System.out.println((i + 1) + ".engeli x ekseninde "
											+ (engel_diziy[i] - (b - 1 + c - d)) + " birim geçtiniz ");
									gecme_sayisi += 1;

								}

								else {

								}

							}

							Scanner scan6 = new Scanner(System.in);
							System.out.println("Yukari doğru kaç birim gidicek : ");
							e = scan6.nextInt();

							if (a - e < 1) {
								System.out.println("Sonn konum. ");
								squares[0][b - 1 - d + c].setIcon(knight);
								System.out.println("gecme sayisi " + gecme_sayisi);

							}

							else if (a - e >= 1) {

								for (int i = 0; i < kacengel; i++) {

									if (engel_dizix[i] >= a - e && b - d + c == engel_diziy[i] && engel_dizix[i] < a) {
										System.out.println((i + 1) + ".engeli y ekseninde " + (engel_dizix[i] - (a - e))
												+ " birim geçtiniz ");
										gecme_sayisi += 1;

									}

									else {

									}

								}

								Scanner scan7 = new Scanner(System.in);
								System.out.println("Aşağı doğru kaç birim gidicek : ");
								f = scan7.nextInt();

								if (a + f - e > 20) {
									System.out.println("Son konum");
									squares[19][b - 1 - d + c].setIcon(knight);
									System.out.println("gecme sayisi " + gecme_sayisi);

								}

								else if (a - e - 1 + f < 20) {

									System.out.println("Son konum");
									squares[a - 1 - e + f][b - 1 - d + c].setIcon(knight);

									for (int i = 0; i < kacengel; i++) {

										if (engel_dizix[i] <= a - e + f && b - d + c == engel_diziy[i]
												&& engel_dizix[i] > a) {
											System.out.println((i + 1) + ".engeli y ekseninde "
													+ ((a - e + f) - engel_dizix[i]) + " birim geçtiniz ");
											gecme_sayisi += 1;

										}

										else {

										}

									}
									System.out.println("gecme sayisi " + gecme_sayisi);

								}
								// HEDEFE ULAŞMA KONTROLÜ

								if ((a - 1 + f - e == hedefx - 1) && (b - 1 - d + c == hedefy - 1)) {
									System.out.println("Tebrikler Hedefe Ulaştınız : ");
								}

								else {
									System.out.println("Hedefe Ulaşamadınız : ");
								}

								System.out.println("Engelden gecme sayisi " + gecme_sayisi);
								double dolasma_suresi = (tk.getgezinmehizi()) / ((c + d + e + f) * 10);
								double engelden_gecme_suresi = gecme_sayisi * tk.engeldengecmesuresibul();

								System.out.println("Engelden geçme suresi  : " + (engelden_gecme_suresi));
								System.out.println("Dolasma suresı Sure : " + (dolasma_suresi));
								System.out.println(
										"Toplamda Harcanan Sure : " + (dolasma_suresi + engelden_gecme_suresi));

							}

						}

					}

					// SURE HESABININ YAPILDIGI BOLGE

				} else if (robotbilgileri[secmedegeri - 1].contains("paletli")) {
					System.out.println(robotbilgileri[secmedegeri - 1]);
					String[] parse = robotbilgileri[secmedegeri - 1].split(" ");

					// PALETLİ ROBOT KONTROLÜ
					main gr = new main();
					gr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					int a, b, c, d, e, f, g, h, engelx = 0, engely = 0, hedefx, hedefy, kacengel, gecme_sayisi = 0;

					Scanner scan = new Scanner(System.in);
					System.out.println("Başlangıç X konumu  : ");
					a = scan.nextInt();
					Scanner scan2 = new Scanner(System.in);
					System.out.println("Başlangıç Y konumu  : ");
					b = scan2.nextInt();
					gr.kullanici(a, b);
					squares[a - 1][b - 1].setIcon(knight);

					Scanner scan95 = new Scanner(System.in);
					System.out.println("Hedef X konumu  : ");
					hedefx = scan95.nextInt();
					Scanner scan99 = new Scanner(System.in);
					System.out.println("Hedef Y konumu  : ");
					hedefy = scan99.nextInt();
					gr.kullanici(hedefx, hedefy);
					squares[hedefx - 1][hedefy - 1].setIcon(hedef);

					Scanner scan75 = new Scanner(System.in);
					System.out.println("Kaç Engel Girmek istersiniz : ");
					kacengel = scan75.nextInt();
					int[] engel_diziy = new int[kacengel];
					int[] engel_dizix = new int[kacengel];

					for (int i = 0; i < kacengel; i++) {
						Scanner scan34 = new Scanner(System.in);
						System.out.println("Engel X konumu  : ");
						engelx = scan34.nextInt();
						Scanner scan35 = new Scanner(System.in);
						System.out.println("Engel Y konumu  : ");
						engely = scan35.nextInt();
						engel_diziy[i] = engely;
						engel_dizix[i] = engelx;
						gr.kullanici(engelx, engely);
						squares[engelx - 1][engely - 1].setIcon(engel);
					}

					Scanner scan3 = new Scanner(System.in);
					System.out.println("Sağa doğru kaç birim gidicek : ");
					c = scan3.nextInt();
					if (b + c > 20) {
						System.out.println("SOn konum ");
						squares[a - 1][19].setIcon(knight);
						System.out.println("gecme sayisi " + gecme_sayisi);

					}

					else if (b - 1 + c < 20) {

						for (int i = 0; i < kacengel; i++) {

							if ((b + c == engel_diziy[i] || b + c >= engel_diziy[i]) && b < engel_diziy[i]
									&& a == engel_dizix[i]) {
								System.out.println((i + 1) + ".engeli x ekseninde " + ((b - 1 + c) - engel_diziy[i])
										+ " birim geçtiniz ");
								gecme_sayisi += 1;

							}

							else {

							}

						}

						Scanner scan5 = new Scanner(System.in);
						System.out.println("Sola doğru kaç birim gidicek : ");
						d = scan5.nextInt();

						if (b - d + c < 1) {
							System.out.println("Son konum : ");
							squares[a - 1][0].setIcon(knight);

						}

						else if (b - d + c >= 1) {

							for (int i = 0; i < kacengel; i++) {
								if ((b + c - d == engel_diziy[i] || b + c - d <= engel_diziy[i])
										&& (b < engel_diziy[i] || b > engel_diziy[i]) && a == engel_dizix[i]) {
									System.out.println((i + 1) + ".engeli x ekseninde "
											+ (engel_diziy[i] - (b - 1 + c - d)) + " birim geçtiniz ");
									gecme_sayisi += 1;

								}

								else {

								}

							}

							Scanner scan6 = new Scanner(System.in);
							System.out.println("Yukari doğru kaç birim gidicek : ");
							e = scan6.nextInt();

							if (a - e < 1) {
								System.out.println("Sonn konum. ");
								squares[0][b - 1 - d + c].setIcon(knight);
								System.out.println("gecme sayisi " + gecme_sayisi);

							}

							else if (a - e >= 1) {

								for (int i = 0; i < kacengel; i++) {

									if (engel_dizix[i] >= a - e && b - d + c == engel_diziy[i] && engel_dizix[i] < a) {
										System.out.println((i + 1) + ".engeli y ekseninde " + (engel_dizix[i] - (a - e))
												+ " birim geçtiniz ");
										gecme_sayisi += 1;

									}

									else {

									}

								}

								Scanner scan7 = new Scanner(System.in);
								System.out.println("Aşağı doğru kaç birim gidicek : ");
								f = scan7.nextInt();

								if (a + f - e > 20) {
									System.out.println("Son konum");
									squares[19][b - 1 - d + c].setIcon(knight);
									System.out.println("gecme sayisi " + gecme_sayisi);

								}

								else if (a - e - 1 + f < 20) {

									System.out.println("Son konum");
									squares[a - 1 - e + f][b - 1 - d + c].setIcon(knight);

									for (int i = 0; i < kacengel; i++) {

										if (engel_dizix[i] <= a - e + f && b - d + c == engel_diziy[i]
												&& engel_dizix[i] > a) {
											System.out.println((i + 1) + ".engeli y ekseninde "
													+ ((a - e + f) - engel_dizix[i]) + " birim geçtiniz ");
											gecme_sayisi += 1;

										}

										else {

										}

									}
									System.out.println("gecme sayisi " + gecme_sayisi);

								}
								// HEDEFE ULAŞMA KONTROLÜ

								if ((a - 1 + f - e == hedefx - 1) && (b - 1 - d + c == hedefy - 1)) {
									System.out.println("Tebrikler Hedefe Ulaştınız : ");
								}

								else {
									System.out.println("Hedefe Ulaşamadınız : ");
								}

								System.out.println("Engelden gecme sayisi " + gecme_sayisi);
								double dolasma_suresi = (palet.getgezinmehizi()) / ((c + d + e + f) * 10);
								double engelden_gecme_suresi = gecme_sayisi * palet.engeldengecmesuresibul();

								System.out.println("Engelden geçme suresi  : " + (engelden_gecme_suresi));
								System.out.println("Dolasma suresı Sure : " + (dolasma_suresi));
								System.out.println(
										"Toplamda Harcanan Sure : " + (dolasma_suresi + engelden_gecme_suresi));

							}

						}

					}

					// SURE HESABININ YAPILDIGI BOLGE

				} else if (robotbilgileri[secmedegeri - 1].contains("spider")) {
					System.out.println(robotbilgileri[secmedegeri - 1]);
					String[] parse = robotbilgileri[secmedegeri - 1].split(" ");

					// Spider Robot grafik hesabı

					main gr = new main();
					gr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					int a, b, c, d, e, f, g, h, engelx = 0, engely = 0, hedefx, hedefy, kacengel, gecme_sayisi = 0;

					Scanner scan = new Scanner(System.in);
					System.out.println("Başlangıç X konumu  : ");
					a = scan.nextInt();
					Scanner scan2 = new Scanner(System.in);
					System.out.println("Başlangıç Y konumu  : ");
					b = scan2.nextInt();
					gr.kullanici(a, b);
					squares[a - 1][b - 1].setIcon(knight);

					Scanner scan95 = new Scanner(System.in);
					System.out.println("Hedef X konumu  : ");
					hedefx = scan95.nextInt();
					Scanner scan99 = new Scanner(System.in);
					System.out.println("Hedef Y konumu  : ");
					hedefy = scan99.nextInt();
					gr.kullanici(hedefx, hedefy);
					squares[hedefx - 1][hedefy - 1].setIcon(hedef);

					Scanner scan75 = new Scanner(System.in);
					System.out.println("Kaç Engel Girmek istersiniz : ");
					kacengel = scan75.nextInt();
					int[] engel_diziy = new int[kacengel];
					int[] engel_dizix = new int[kacengel];

					for (int i = 0; i < kacengel; i++) {
						Scanner scan34 = new Scanner(System.in);
						System.out.println("Engel X konumu  : ");
						engelx = scan34.nextInt();
						Scanner scan35 = new Scanner(System.in);
						System.out.println("Engel Y konumu  : ");
						engely = scan35.nextInt();
						engel_diziy[i] = engely;
						engel_dizix[i] = engelx;
						gr.kullanici(engelx, engely);
						squares[engelx - 1][engely - 1].setIcon(engel);
					}

					Scanner scan3 = new Scanner(System.in);
					System.out.println("Sağa doğru kaç birim gidicek : ");
					c = scan3.nextInt();
					if (b + c > 20) {

						System.out.println("Alan dışına çıktınız. SOn konum ");
						squares[a - 1][19].setIcon(knight);

					}

					else if (b - 1 + c < 20) {

						for (int i = 0; i < kacengel; i++) {

							while (engel_diziy[i] <= b + c && a == engel_dizix[i] && engel_diziy[i] > b) {

								System.out.println("Engelden gecemessiniz : ");

								System.out.println("SOn konum ");
								squares[a - 1][engel_diziy[i] - 2].setIcon(knight);
								c = scan3.nextInt();
								double dolasma_suresi = (spd.getgezinmehizi()) / ((engel_diziy[i] - 2) * 10);
								System.out.println("Toplamda Harcanan Sure : " + (dolasma_suresi));
								System.exit(1);

								break;

							}

						}

						Scanner scan5 = new Scanner(System.in);
						System.out.println("Sola doğru kaç birim gidicek : ");
						d = scan5.nextInt();

						if (b - d + c < 1) {
							System.out.println("Son konum : ");
							squares[a - 1][0].setIcon(knight);

						}

						else if (b - d + c >= 1) {

							for (int i = 0; i < kacengel; i++) {
								while (engel_diziy[i] >= b + c - d && a == engel_dizix[i] && engel_diziy[i] < b) {
									System.out.println("Engelden gecemessiniz : ");

									System.out.println("SOn konum ");
									squares[a - 1][engel_diziy[i]].setIcon(knight);
									double dolasma_suresi = (spd.getgezinmehizi()) / ((engel_diziy[i] + c) * 10);
									System.out.println("Toplamda Harcanan Sure : " + (dolasma_suresi));

									c = scan3.nextInt();
									System.exit(1);

									break;

								}

							}

							Scanner scan6 = new Scanner(System.in);
							System.out.println("Yukari doğru kaç birim gidicek : ");
							e = scan6.nextInt();

							if (a - e < 1) {
								System.out.println("Sonn konum. ");
								squares[0][b - 1 - d + c].setIcon(knight);

							}

							else if (a - e >= 1) {

								for (int i = 0; i < kacengel; i++) {
									while (engel_dizix[i] >= a - e && b - d + c == engel_diziy[i]
											&& engel_dizix[i] < a) {
										System.out.println("Engelden gecemessiniz : ");

										System.out.println("SOn konum ");
										squares[engel_dizix[i]][b - 1 - d + c].setIcon(knight);
										double dolasma_suresi = (spd.getgezinmehizi())
												/ ((b + c + engel_dizix[i]) * 10);
										System.out.println("Toplamda Harcanan Sure : " + (dolasma_suresi));

										c = scan3.nextInt();
										System.exit(1);

										break;

									}

								}

								Scanner scan7 = new Scanner(System.in);
								System.out.println("Aşağı doğru kaç birim gidicek : ");
								f = scan7.nextInt();

								if (a + f - e > 20) {
									System.out.println("Son konum");
									squares[19][b - 1 - d + c].setIcon(knight);

								}

								else if (a - e - 1 + f < 20) {

									for (int i = 0; i < kacengel; i++) {
										while (engel_dizix[i] <= a - e + f && b - d + c == engel_diziy[i]
												&& engel_dizix[i] > a) {
											System.out.println("Engelden gecemessiniz : ");

											System.out.println("SOn konum ");
											squares[engel_dizix[i] - 2][b - 1 - d + c].setIcon(knight);
											double dolasma_suresi = (spd.getgezinmehizi())
													/ ((b + c + d + engel_dizix[i] - 2) * 10);
											System.out.println("Toplamda Harcanan Sure : " + (dolasma_suresi));

											c = scan3.nextInt();
											System.exit(1);

											break;

										}

									}

									System.out.println("Son konum");
									squares[a - 1 - e + f][b - 1 - d + c].setIcon(knight);

								}
								// HEDEFE ULAŞMA KONTROLÜ

								if ((a - 1 + f - e == hedefx - 1) && (b - 1 - d + c == hedefy - 1)) {
									System.out.println("Tebrikler Hedefe Ulaştınız : ");
									double dolasma_suresi = (spd.getgezinmehizi()) / ((c + d + e + f) * 10);
									System.out.println("Toplamda Harcanan Sure : " + (dolasma_suresi));
								}

								else {
									System.out.println("Hedefe Ulaşamadınız : ");
									double dolasma_suresi = (spd.getgezinmehizi()) / ((c + d + e + f) * 10);
									System.out.println("Toplamda Harcanan Sure : " + (dolasma_suresi));
								}

							}

						}

					}

				} else if (robotbilgileri[secmedegeri - 1].contains("seri")) {
					System.out.println(robotbilgileri[secmedegeri - 1]);
					String[] parse = robotbilgileri[secmedegeri - 1].split(" ");

					// Seri Robot GRAFİĞİ

					main gr = new main();
					gr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h, engelx = 0, engely = 0, hedefx, hedefy,
							kacengel, gecme_sayisi = 0;

					Scanner scan = new Scanner(System.in);
					System.out.println("Başlangıç X konumu  : ");
					a = scan.nextInt();
					Scanner scan2 = new Scanner(System.in);
					System.out.println("Başlangıç Y konumu  : ");
					b = scan2.nextInt();
					gr.kullanici(a, b);
					squares[a - 1][b - 1].setIcon(maniprobot);

					Scanner scan95 = new Scanner(System.in);
					System.out.println("Hedef X konumu  : ");
					hedefx = scan95.nextInt();
					Scanner scan99 = new Scanner(System.in);
					System.out.println("Hedef Y konumu  : ");
					hedefy = scan99.nextInt();
					gr.kullanici(hedefx, hedefy);
					squares[hedefx - 1][hedefy - 1].setIcon(hedef);

					System.out.println("seri robot kol uzunluğu" + sr.getKoluzunlugu());

					Scanner scan9 = new Scanner(System.in);
					System.out.println("Sağa doğru kaç birim gidecek");
					c = scan9.nextInt();

					if (b + c > 20) {
						System.out.println("Alan dışı SOn konum ");
						squares[a - 1][19].setIcon(yuk);

					}

					else if (b - 1 + c < 20) {

						if (sr.getKoluzunlugu() < (c * 10)) {

							System.out
									.println(" Kol uzunluğu  kısa olduğu için daha fazla hareket edemez Son Konum : ");

							System.out.println("SOn konum ");
							squares[a - 1][b - 1 + (sr.getKoluzunlugu() / 10)].setIcon(yuk);

						}

						else {

							Scanner scan5 = new Scanner(System.in);
							System.out.println("Sola doğru kaç birim gidicek : ");
							d = scan5.nextInt();

							if (b - d + c < 1) {
								System.out.println("Son konum : ");
								squares[a - 1][0].setIcon(yuk);

							}

							else if (b - d + c >= 1) {

								if ((sr.getKoluzunlugu() - c * 10) < (d * 10)) {

									System.out.println(
											" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
									squares[a - 1][b - 1 - (sr.getKoluzunlugu() / 10 - c) + c].setIcon(yuk);

								}

								else {

									Scanner scan6 = new Scanner(System.in);
									System.out.println("Yukari doğru kaç birim gidicek : ");
									e = scan6.nextInt();

									if (a - e < 1) {
										System.out.println("Alan dışına çıktınız Sonn konum. ");
										squares[0][b - 1 - d + c].setIcon(yuk);

									}

									else if (a - e >= 1) {

										if ((sr.getKoluzunlugu() - (c * 10) - (d * 10)) < (e * 10)) {

											System.out.println(
													" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
											squares[a - 1 - (sr.getKoluzunlugu() / 10 - (c + d))][b - 1 + c - d]
													.setIcon(yuk);

										}

										else {

											Scanner scan7 = new Scanner(System.in);
											System.out.println("Aşağı doğru kaç birim gidicek : ");
											f = scan7.nextInt();

											if (a + f - e > 20) {
												System.out.println("Alan dışına çıktınız Son konum");
												squares[19][b - 1 - d + c].setIcon(yuk);

											}

											else if (a - e - 1 + f < 20) {

												if ((sr.getKoluzunlugu() - (c * 10) - (d * 10) - (e * 10)) < (f * 10)) {

													System.out.println(
															" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
													squares[a - 1 - e + (sr.getKoluzunlugu() / 10 - (e + d + c))][b - 1
															+ c - d].setIcon(yuk);

												}

												else {

													System.out.println("Girilen değerler sonucunda ki son konumunuz");
													squares[a - 1 - e + f][b - 1 - d + c].setIcon(yuk);

													if ((a - 1 + f - e == hedefx - 1)
															&& (b - 1 - d + c == hedefy - 1)) {
														System.out.println("Tebrikler Hedefe Ulaştınız : ");
													}

													else {
														System.out.println("Hedefe Ulaşamadınız : ");
													}

												}

											}

										}

									}

								}

							}

						}

					}

					// SURE HESABININ YAPILDIGI BOLGE
					double dolasma_suresi = (sr.gettasinmahizi()) / ((c + d + e + f) * 10);
					System.out.println("Toplamda Harcanan Sure : " + (dolasma_suresi));

				} else if (robotbilgileri[secmedegeri - 1].contains("paralel")) {
					System.out.println(robotbilgileri[secmedegeri - 1]);
					String[] parse = robotbilgileri[secmedegeri - 1].split(" ");

					// PARALEL ROBOT GRAFİĞİ

					main gr = new main();
					gr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					int a, b, c, d = 0, e = 0, f = 0, g = 0, h, engelx = 0, engely = 0, hedefx, hedefy, kacengel,
							gecme_sayisi = 0;

					Scanner scan = new Scanner(System.in);
					System.out.println("Başlangıç X konumu  : ");
					a = scan.nextInt();
					Scanner scan2 = new Scanner(System.in);
					System.out.println("Başlangıç Y konumu  : ");
					b = scan2.nextInt();
					gr.kullanici(a, b);
					squares[a - 1][b - 1].setIcon(maniprobot);

					Scanner scan95 = new Scanner(System.in);
					System.out.println("Hedef X konumu  : ");
					hedefx = scan95.nextInt();
					Scanner scan99 = new Scanner(System.in);
					System.out.println("Hedef Y konumu  : ");
					hedefy = scan99.nextInt();
					gr.kullanici(hedefx, hedefy);
					squares[hedefx - 1][hedefy - 1].setIcon(hedef);

					System.out.println("paralel robot kol uzunluğu : " + pr.getKoluzunlugu());

					Scanner scan9 = new Scanner(System.in);
					System.out.println("Sağa doğru kaç birim gidecek");
					c = scan9.nextInt();

					if (b + c > 20) {
						System.out.println("Alan dışı SOn konum ");
						squares[a - 1][19].setIcon(yuk);

					}

					else if (b - 1 + c < 20) {

						if (pr.getKoluzunlugu() < (c * 10)) {

							System.out
									.println(" Kol uzunluğu  kısa olduğu için daha fazla hareket edemez Son Konum : ");

							System.out.println("SOn konum ");
							squares[a - 1][b - 1 + (pr.getKoluzunlugu() / 10)].setIcon(yuk);

						}

						else {

							Scanner scan5 = new Scanner(System.in);
							System.out.println("Sola doğru kaç birim gidicek : ");
							d = scan5.nextInt();

							if (b - d + c < 1) {
								System.out.println("Son konum : ");
								squares[a - 1][0].setIcon(yuk);

							}

							else if (b - d + c >= 1) {

								if ((pr.getKoluzunlugu() - c * 10) < (d * 10)) {

									System.out.println(
											" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
									squares[a - 1][b - 1 - (pr.getKoluzunlugu() / 10 - c) + c].setIcon(yuk);

								}

								else {

									Scanner scan6 = new Scanner(System.in);
									System.out.println("Yukari doğru kaç birim gidicek : ");
									e = scan6.nextInt();

									if (a - e < 1) {
										System.out.println("Alan dışına çıktınız Sonn konum. ");
										squares[0][b - 1 - d + c].setIcon(yuk);

									}

									else if (a - e >= 1) {

										if ((pr.getKoluzunlugu() - (c * 10) - (d * 10)) < (e * 10)) {

											System.out.println(
													" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
											squares[a - 1 - (pr.getKoluzunlugu() / 10 - (c + d))][b - 1 + c - d]
													.setIcon(yuk);

										}

										else {

											Scanner scan7 = new Scanner(System.in);
											System.out.println("Aşağı doğru kaç birim gidicek : ");
											f = scan7.nextInt();

											if (a + f - e > 20) {
												System.out.println("Alan dışına çıktınız Son konum");
												squares[19][b - 1 - d + c].setIcon(yuk);

											}

											else if (a - e - 1 + f < 20) {

												if ((pr.getKoluzunlugu() - (c * 10) - (d * 10) - (e * 10)) < (f * 10)) {

													System.out.println(
															" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
													squares[a - 1 - e + (pr.getKoluzunlugu() / 10 - (e + d + c))][b - 1
															+ c - d].setIcon(yuk);

												}

												else {

													System.out.println("Girilen değerler sonucunda ki son konumunuz");
													squares[a - 1 - e + f][b - 1 - d + c].setIcon(yuk);

													if ((a - 1 + f - e == hedefx - 1)
															&& (b - 1 - d + c == hedefy - 1)) {
														System.out.println("Tebrikler Hedefe Ulaştınız : ");
													}

													else {
														System.out.println("Hedefe Ulaşamadınız : ");
													}

												}

											}

										}

									}

								}

							}

						}

					}
					// SURE HESABININ YAPILDIGI BOLGE
					double dolasma_suresi = (pr.gettasinmahizi()) / ((c + d + e + f) * 10);
					System.out.println("Toplamda Harcanan Sure : " + (dolasma_suresi));

				} else if (robotbilgileri[secmedegeri - 1].contains("tekser")) {
					System.out.println(robotbilgileri[secmedegeri - 1]);
					String[] parse = robotbilgileri[secmedegeri - 1].split(" ");

					main gr = new main();
					gr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					int a, b, c, d = 0, e=0, f=0, g, h, engelx = 0, engely = 0, hedefx, hedefy, kacengel, sabitnoktax,
							sabitnoktay, sag = 0, sol = 0, yukari = 0, asagi = 0, gecme_sayisi = 0;

					Scanner scan = new Scanner(System.in);
					System.out.println("Başlangıç X  : ");
					a = scan.nextInt();
					Scanner scan2 = new Scanner(System.in);
					System.out.println("Başlangıç Y  : ");
					b = scan2.nextInt();
					gr.kullanici(a, b);
					squares[a - 1][b - 1].setIcon(gezginmanip);

					Scanner scan21 = new Scanner(System.in);
					System.out.println("Sabit nokta X  : ");
					sabitnoktax = scan2.nextInt();
					Scanner scan22 = new Scanner(System.in);
					System.out.println("Sabit Nokta Y  : ");
					sabitnoktay = scan22.nextInt();
					gr.kullanici(sabitnoktax, sabitnoktay);
					squares[sabitnoktax - 1][sabitnoktay - 1].setIcon(sabit);

					Scanner scan95 = new Scanner(System.in);
					System.out.println("Hedef X  : ");
					hedefx = scan95.nextInt();
					Scanner scan99 = new Scanner(System.in);
					System.out.println("Hedef Y  : ");
					hedefy = scan99.nextInt();
					gr.kullanici(hedefx, hedefy);
					squares[hedefx - 1][hedefy - 1].setIcon(hedef);

					Scanner scan75 = new Scanner(System.in);
					System.out.println("Kaç Engel Girmek istersiniz : ");
					kacengel = scan75.nextInt();
					int[] engel_diziy = new int[kacengel];
					int[] engel_dizix = new int[kacengel];

					for (int i = 0; i < kacengel; i++) {
						Scanner scan34 = new Scanner(System.in);
						System.out.println("Engel X  : ");
						engelx = scan34.nextInt();
						Scanner scan35 = new Scanner(System.in);
						System.out.println("Engel Y  : ");
						engely = scan35.nextInt();
						engel_diziy[i] = engely;
						engel_dizix[i] = engelx;
						gr.kullanici(engelx, engely);
						squares[engelx - 1][engely - 1].setIcon(engel);
					}

					int y = 0;

					Scanner scan3 = new Scanner(System.in);
					System.out.println("Sağa doğru kaç birim gidicek : ");
					c = scan3.nextInt();
					if (b + c > 20) {
						System.out.println("Alan dışı SOn konum ");
						squares[a - 1][19].setIcon(gezginmanip);
						System.out.println("gecme sayisi " + gecme_sayisi);

					}

					else if (b - 1 + c < 20) {

						for (int i = 0; i < kacengel; i++) {

							if ((b + c == engel_diziy[i] || b + c >= engel_diziy[i]) && b < engel_diziy[i]
									&& a == engel_dizix[i]) {
								System.out.println((i + 1) + ".engeli x ekseninde " + ((b - 1 + c) - engel_diziy[i])
										+ " birim geçtiniz ");
								gecme_sayisi += 1;

							}

							else {

							}

						}

						Scanner scan5 = new Scanner(System.in);
						System.out.println("Sola doğru kaç birim gidicek : ");
						d = scan5.nextInt();

						if (b - d + c < 1) {
							System.out.println("Alan dışı Son konum : ");
							squares[a - 1][0].setIcon(gezginmanip);

						}

						else if (b - d + c >= 1) {

							for (int i = 0; i < kacengel; i++) {
								if ((b + c - d == engel_diziy[i] || b + c - d <= engel_diziy[i])
										&& (b < engel_diziy[i] || b > engel_diziy[i]) && a == engel_dizix[i]) {
									System.out.println((i + 1) + ".engeli x ekseninde "
											+ (engel_diziy[i] - (b - 1 + c - d)) + " birim geçtiniz ");
									gecme_sayisi += 1;

								}

								else {

								}

							}

							Scanner scan6 = new Scanner(System.in);
							System.out.println("Yukari doğru kaç birim gidicek : ");
							e = scan6.nextInt();

							if (a - e < 1) {
								System.out.println("Alan dışı Son konum. ");
								squares[0][b - 1 - d + c].setIcon(gezginmanip);
								System.out.println("gecme sayisi " + gecme_sayisi);

							}

							else if (a - e >= 1) {

								for (int i = 0; i < kacengel; i++) {

									if (engel_dizix[i] >= a - e && b - d + c == engel_diziy[i] && engel_dizix[i] < a) {
										System.out.println((i + 1) + ".engeli y ekseninde " + (engel_dizix[i] - (a - e))
												+ " birim geçtiniz ");
										gecme_sayisi += 1;

									}

									else {

									}

								}

								Scanner scan7 = new Scanner(System.in);
								System.out.println("Aşağı doğru kaç birim gidicek : ");
								f = scan7.nextInt();

								if (a + f - e > 20) {
									System.out.println("Alan dışı Son konum");
									squares[19][b - 1 - d + c].setIcon(gezginmanip);
									System.out.println("gecme sayisi " + gecme_sayisi);

								}

								else if (a - e - 1 + f < 20) {

									System.out.println("Son konum");
									squares[a - 1 - e + f][b - 1 - d + c].setIcon(gezginmanip);

									for (int i = 0; i < kacengel; i++) {

										if (engel_dizix[i] <= a - e + f && b - d + c == engel_diziy[i]
												&& engel_dizix[i] > a) {
											System.out.println((i + 1) + ".engeli y ekseninde "
													+ ((a - e + f) - engel_dizix[i]) + " birim geçtiniz ");
											gecme_sayisi += 1;

										}

										else {

										}

									}
									System.out.println("gecme sayisi " + gecme_sayisi);

								}
								// HEDEFE ULAŞMA KONTROLÜ
								// 2.KISIM

								if ((a - 1 + f - e == sabitnoktax - 1) && (b - 1 - d + c == sabitnoktay - 1)) {
									System.out.println("Sabit Noktaya Ulaştınız : ");

									System.out.println("GezginManip robot kol uzunluğu : " + gm.getKoluzunlugu());

									Scanner scan9 = new Scanner(System.in);
									System.out.println("Sağa doğru kaç birim gidecek");
									sag = scan9.nextInt();

									if (b - 1 - d + c + sag > 20) {
										System.out.println("Alan dışı SOn konum ");
										squares[a - 1 + f - e][19].setIcon(yuk);

									}

									else if (b - 1 - d + c + sag < 20) {

										if (gm.getKoluzunlugu() < (sag * 10)) {

											System.out.println(
													" Kol uzunluğu  kısa olduğu için daha fazla hareket edemez Son Konum : ");
											squares[a - 1 + f - e][b - 1 - d + c + (gm.getKoluzunlugu() / 10)]
													.setIcon(yuk);

										}

										else {

											Scanner scan55 = new Scanner(System.in);
											System.out.println("Sola doğru kaç birim gidicek : ");
											sol = scan55.nextInt();

											if (b - 1 - d + c + sag - sol < 1) {
												System.out.println("Alan  dışı Son konum : ");
												squares[a - 1 + f - e][0].setIcon(yuk);

											}

											else if (b - 1 - d + c + sag - sol >= 1) {

												if ((gm.getKoluzunlugu() - sag * 10) < (sol * 10)) {

													System.out.println(
															" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
													squares[a - 1 + f - e][b - 1 - d + c
															- (gm.getKoluzunlugu() / 10 - sag) + sag].setIcon(yuk);

												}

												else {

													Scanner scan66 = new Scanner(System.in);
													System.out.println("Yukari doğru kaç birim gidicek : ");
													yukari = scan66.nextInt();

													if (a - 1 + f - e - yukari < 1) {
														System.out.println("Alan dışına çıktınız Sonn konum. ");
														squares[0][b - 1 - d + c + sag - sol].setIcon(yuk);

													}

													else if (a - 1 + f - e - yukari >= 1) {

														if ((gm.getKoluzunlugu() - (sag * 10) - (sol * 10)) < (yukari
																* 10)) {

															System.out.println(
																	" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
															squares[a - 1 + f - e
																	- (gm.getKoluzunlugu() / 10 - (sag + sol))][b - 1
																			+ c - d + sag - sol].setIcon(yuk);

														}

														else {

															Scanner scan77 = new Scanner(System.in);
															System.out.println("Aşağı doğru kaç birim gidicek : ");
															asagi = scan77.nextInt();

															if (a - 1 + f - e - yukari + asagi > 20) {
																System.out.println("Alan dışına çıktınız Son konum");
																squares[19][b - 1 - d + c + sag - sol].setIcon(yuk);

															}

															else if (a - 1 + f - e - yukari + asagi < 20) {

																if ((gm.getKoluzunlugu() - (sag * 10) - (sol * 10)
																		- (yukari * 10)) < (asagi * 10)) {

																	System.out.println(
																			" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
																	squares[a - 1 + f - e - yukari
																			+ (gm.getKoluzunlugu() / 10
																					- (sag + sol + yukari))][b - 1 + c
																							- d + sag - sol]
																									.setIcon(yuk);

																}

																else {

																	System.out.println(
																			"Girilen değerler sonucunda ki son konumunuz");
																	squares[a - 1 + f - e - yukari + asagi][b - 1 + c
																			- d + sag - sol].setIcon(yuk);

																	if ((a - 1 + f - e - yukari + asagi == hedefx - 1)
																			&& (b - 1 + c - d + sag - sol == hedefy
																					- 1)) {
																		System.out.println(
																				"Tebrikler Hedefe Ulaştınız : ");
																	}

																	else {
																		System.out.println("Hedefe Ulaşamadınız : ");
																	}

																}

															}

														}

													}

												}

											}

										}

									}

								}

								else {
									System.out.println("Sabit Noktaya Ulaşamadınız : ");
								}
								

							}

						}

					}
					
					double gezinme_suresi=0,engelden_gecme_suresi=0,koldolasma_suresi=0;
					System.out.println("Engelden gecme sayisi " + gecme_sayisi);
					gezinme_suresi = (gm.getgezinmehizi()) / ((c + d + e + f) * 10);
					engelden_gecme_suresi = gecme_sayisi * gm.engeldengecmesuresibul() * 0.5;
					koldolasma_suresi = (gm.gettasinmahizi()) / ((sag + sol + yukari + asagi) * 10);

					System.out.println("Engelden geçme suresi  : " + (engelden_gecme_suresi));
					System.out.println("Gezinme suresı suresi : " + (gezinme_suresi));
					System.out.println("Kol dolasma suresi  : " + (koldolasma_suresi));
					System.out.println("Toplamda Harcanan Sure : " + (gezinme_suresi + koldolasma_suresi
							+ engelden_gecme_suresi + gm.getSabitlemesuresi()));

				}

				else if (robotbilgileri[secmedegeri - 1].contains("tkpar")) {
					System.out.println(robotbilgileri[secmedegeri - 1]);
					String[] parse = robotbilgileri[secmedegeri - 1].split(" ");

					main gr = new main();
					gr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					int a, b, c=0, d=0, e=0, f=0, g, h, engelx = 0, engely = 0, hedefx, hedefy, kacengel, sabitnoktax,
							sabitnoktay, sag = 0, sol = 0, yukari = 0, asagi = 0, gecme_sayisi = 0;

					Scanner scan = new Scanner(System.in);
					System.out.println("Başlangıç X  : ");
					a = scan.nextInt();
					Scanner scan2 = new Scanner(System.in);
					System.out.println("Başlangıç Y  : ");
					b = scan2.nextInt();
					gr.kullanici(a, b);
					squares[a - 1][b - 1].setIcon(gezginmanip);

					Scanner scan21 = new Scanner(System.in);
					System.out.println("Sabit nokta X  : ");
					sabitnoktax = scan2.nextInt();
					Scanner scan22 = new Scanner(System.in);
					System.out.println("Sabit Nokta Y  : ");
					sabitnoktay = scan22.nextInt();
					gr.kullanici(sabitnoktax, sabitnoktay);
					squares[sabitnoktax - 1][sabitnoktay - 1].setIcon(sabit);

					Scanner scan95 = new Scanner(System.in);
					System.out.println("Hedef X  : ");
					hedefx = scan95.nextInt();
					Scanner scan99 = new Scanner(System.in);
					System.out.println("Hedef Y  : ");
					hedefy = scan99.nextInt();
					gr.kullanici(hedefx, hedefy);
					squares[hedefx - 1][hedefy - 1].setIcon(hedef);

					Scanner scan75 = new Scanner(System.in);
					System.out.println("Kaç Engel Girmek istersiniz : ");
					kacengel = scan75.nextInt();
					int[] engel_diziy = new int[kacengel];
					int[] engel_dizix = new int[kacengel];

					for (int i = 0; i < kacengel; i++) {
						Scanner scan34 = new Scanner(System.in);
						System.out.println("Engel X  : ");
						engelx = scan34.nextInt();
						Scanner scan35 = new Scanner(System.in);
						System.out.println("Engel Y  : ");
						engely = scan35.nextInt();
						engel_diziy[i] = engely;
						engel_dizix[i] = engelx;
						gr.kullanici(engelx, engely);
						squares[engelx - 1][engely - 1].setIcon(engel);
					}

					int y = 0;

					Scanner scan3 = new Scanner(System.in);
					System.out.println("Sağa doğru kaç birim gidicek : ");
					c = scan3.nextInt();
					if (b + c > 20) {
						System.out.println("Alan dışı SOn konum ");
						squares[a - 1][19].setIcon(gezginmanip);
						System.out.println("gecme sayisi " + gecme_sayisi);

					}

					else if (b - 1 + c < 20) {

						for (int i = 0; i < kacengel; i++) {

							if ((b + c == engel_diziy[i] || b + c >= engel_diziy[i]) && b < engel_diziy[i]
									&& a == engel_dizix[i]) {
								System.out.println((i + 1) + ".engeli x ekseninde " + ((b - 1 + c) - engel_diziy[i])
										+ " birim geçtiniz ");
								gecme_sayisi += 1;

							}

							else {

							}

						}

						Scanner scan5 = new Scanner(System.in);
						System.out.println("Sola doğru kaç birim gidicek : ");
						d = scan5.nextInt();

						if (b - d + c < 1) {
							System.out.println("Alan dışı Son konum : ");
							squares[a - 1][0].setIcon(gezginmanip);

						}

						else if (b - d + c >= 1) {

							for (int i = 0; i < kacengel; i++) {
								if ((b + c - d == engel_diziy[i] || b + c - d <= engel_diziy[i])
										&& (b < engel_diziy[i] || b > engel_diziy[i]) && a == engel_dizix[i]) {
									System.out.println((i + 1) + ".engeli x ekseninde "
											+ (engel_diziy[i] - (b - 1 + c - d)) + " birim geçtiniz ");
									gecme_sayisi += 1;

								}

								else {

								}

							}

							Scanner scan6 = new Scanner(System.in);
							System.out.println("Yukari doğru kaç birim gidicek : ");
							e = scan6.nextInt();

							if (a - e < 1) {
								System.out.println("Alan dışı Son konum. ");
								squares[0][b - 1 - d + c].setIcon(gezginmanip);
								System.out.println("gecme sayisi " + gecme_sayisi);

							}

							else if (a - e >= 1) {

								for (int i = 0; i < kacengel; i++) {

									if (engel_dizix[i] >= a - e && b - d + c == engel_diziy[i] && engel_dizix[i] < a) {
										System.out.println((i + 1) + ".engeli y ekseninde " + (engel_dizix[i] - (a - e))
												+ " birim geçtiniz ");
										gecme_sayisi += 1;

									}

									else {

									}

								}

								Scanner scan7 = new Scanner(System.in);
								System.out.println("Aşağı doğru kaç birim gidicek : ");
								f = scan7.nextInt();

								if (a + f - e > 20) {
									System.out.println("Alan dışı Son konum");
									squares[19][b - 1 - d + c].setIcon(gezginmanip);
									System.out.println("gecme sayisi " + gecme_sayisi);

								}

								else if (a - e - 1 + f < 20) {

									System.out.println("Son konum");
									squares[a - 1 - e + f][b - 1 - d + c].setIcon(gezginmanip);

									for (int i = 0; i < kacengel; i++) {

										if (engel_dizix[i] <= a - e + f && b - d + c == engel_diziy[i]
												&& engel_dizix[i] > a) {
											System.out.println((i + 1) + ".engeli y ekseninde "
													+ ((a - e + f) - engel_dizix[i]) + " birim geçtiniz ");
											gecme_sayisi += 1;

										}

										else {

										}

									}
									System.out.println("gecme sayisi " + gecme_sayisi);

								}
								// HEDEFE ULAŞMA KONTROLÜ
								// 2.KISIM

								if ((a - 1 + f - e == sabitnoktax - 1) && (b - 1 - d + c == sabitnoktay - 1)) {
									System.out.println("Sabit Noktaya Ulaştınız : ");

									System.out.println("GezginManip robot kol uzunluğu : " + gm.getKoluzunlugu());

									Scanner scan9 = new Scanner(System.in);
									System.out.println("Sağa doğru kaç birim gidecek");
									sag = scan9.nextInt();

									if (b - 1 - d + c + sag > 20) {
										System.out.println("Alan dışı SOn konum ");
										squares[a - 1 + f - e][19].setIcon(yuk);

									}

									else if (b - 1 - d + c + sag < 20) {

										if (gm.getKoluzunlugu() < (sag * 10)) {

											System.out.println(
													" Kol uzunluğu  kısa olduğu için daha fazla hareket edemez Son Konum : ");
											squares[a - 1 + f - e][b - 1 - d + c + (gm.getKoluzunlugu() / 10)]
													.setIcon(yuk);

										}

										else {

											Scanner scan55 = new Scanner(System.in);
											System.out.println("Sola doğru kaç birim gidicek : ");
											sol = scan55.nextInt();

											if (b - 1 - d + c + sag - sol < 1) {
												System.out.println("Alan  dışı Son konum : ");
												squares[a - 1 + f - e][0].setIcon(yuk);

											}

											else if (b - 1 - d + c + sag - sol >= 1) {

												if ((gm.getKoluzunlugu() - sag * 10) < (sol * 10)) {

													System.out.println(
															" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
													squares[a - 1 + f - e][b - 1 - d + c
															- (gm.getKoluzunlugu() / 10 - sag) + sag].setIcon(yuk);

												}

												else {

													Scanner scan66 = new Scanner(System.in);
													System.out.println("Yukari doğru kaç birim gidicek : ");
													yukari = scan66.nextInt();

													if (a - 1 + f - e - yukari < 1) {
														System.out.println("Alan dışına çıktınız Sonn konum. ");
														squares[0][b - 1 - d + c + sag - sol].setIcon(yuk);

													}

													else if (a - 1 + f - e - yukari >= 1) {

														if ((gm.getKoluzunlugu() - (sag * 10) - (sol * 10)) < (yukari
																* 10)) {

															System.out.println(
																	" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
															squares[a - 1 + f - e
																	- (gm.getKoluzunlugu() / 10 - (sag + sol))][b - 1
																			+ c - d + sag - sol].setIcon(yuk);

														}

														else {

															Scanner scan77 = new Scanner(System.in);
															System.out.println("Aşağı doğru kaç birim gidicek : ");
															asagi = scan77.nextInt();

															if (a - 1 + f - e - yukari + asagi > 20) {
																System.out.println("Alan dışına çıktınız Son konum");
																squares[19][b - 1 - d + c + sag - sol].setIcon(yuk);

															}

															else if (a - 1 + f - e - yukari + asagi < 20) {

																if ((gm.getKoluzunlugu() - (sag * 10) - (sol * 10)
																		- (yukari * 10)) < (asagi * 10)) {

																	System.out.println(
																			" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
																	squares[a - 1 + f - e - yukari
																			+ (gm.getKoluzunlugu() / 10
																					- (sag + sol + yukari))][b - 1 + c
																							- d + sag - sol]
																									.setIcon(yuk);

																}

																else {

																	System.out.println(
																			"Girilen değerler sonucunda ki son konumunuz");
																	squares[a - 1 + f - e - yukari + asagi][b - 1 + c
																			- d + sag - sol].setIcon(yuk);

																	if ((a - 1 + f - e - yukari + asagi == hedefx - 1)
																			&& (b - 1 + c - d + sag - sol == hedefy
																					- 1)) {
																		System.out.println(
																				"Tebrikler Hedefe Ulaştınız : ");
																	}

																	else {
																		System.out.println("Hedefe Ulaşamadınız : ");
																	}

																}

															}

														}

													}

												}

											}

										}

									}

								}

								else {
									System.out.println("Sabit Noktaya Ulaşamadınız : ");
								}
								
							}

						}

					}
					
					double gezinme_suresi=0,engelden_gecme_suresi=0,koldolasma_suresi=0;
					System.out.println("Engelden gecme sayisi " + gecme_sayisi);
					gezinme_suresi = (gm.getgezinmehizi()) / ((c + d + e + f) * 10);
					engelden_gecme_suresi = gecme_sayisi * gm.engeldengecmesuresibul() * 0.5;
					koldolasma_suresi = (gm.gettasinmahizi()) / ((sag + sol + yukari + asagi) * 10);

					System.out.println("Engelden geçme suresi  : " + (engelden_gecme_suresi));
					System.out.println("Gezinme suresı suresi : " + (gezinme_suresi));
					System.out.println("Kol dolasma suresi  : " + (koldolasma_suresi));
					System.out.println("Toplamda Harcanan Sure : " + (gezinme_suresi + koldolasma_suresi
							+ engelden_gecme_suresi + gm.getSabitlemesuresi()));


				} else if (robotbilgileri[secmedegeri - 1].contains("palser")) {
					System.out.println(robotbilgileri[secmedegeri - 1]);
					String[] parse = robotbilgileri[secmedegeri - 1].split(" ");

					main gr = new main();
					gr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					int a, b, c=0, d=0, e=0, f=0, g, h, engelx = 0, engely = 0, hedefx, hedefy, kacengel, sabitnoktax,
							sabitnoktay, sag = 0, sol = 0, yukari = 0, asagi = 0, gecme_sayisi = 0;

					Scanner scan = new Scanner(System.in);
					System.out.println("Başlangıç X  : ");
					a = scan.nextInt();
					Scanner scan2 = new Scanner(System.in);
					System.out.println("Başlangıç Y  : ");
					b = scan2.nextInt();
					gr.kullanici(a, b);
					squares[a - 1][b - 1].setIcon(gezginmanip);

					Scanner scan21 = new Scanner(System.in);
					System.out.println("Sabit nokta X  : ");
					sabitnoktax = scan2.nextInt();
					Scanner scan22 = new Scanner(System.in);
					System.out.println("Sabit Nokta Y  : ");
					sabitnoktay = scan22.nextInt();
					gr.kullanici(sabitnoktax, sabitnoktay);
					squares[sabitnoktax - 1][sabitnoktay - 1].setIcon(sabit);

					Scanner scan95 = new Scanner(System.in);
					System.out.println("Hedef X  : ");
					hedefx = scan95.nextInt();
					Scanner scan99 = new Scanner(System.in);
					System.out.println("Hedef Y  : ");
					hedefy = scan99.nextInt();
					gr.kullanici(hedefx, hedefy);
					squares[hedefx - 1][hedefy - 1].setIcon(hedef);

					Scanner scan75 = new Scanner(System.in);
					System.out.println("Kaç Engel Girmek istersiniz : ");
					kacengel = scan75.nextInt();
					int[] engel_diziy = new int[kacengel];
					int[] engel_dizix = new int[kacengel];

					for (int i = 0; i < kacengel; i++) {
						Scanner scan34 = new Scanner(System.in);
						System.out.println("Engel X  : ");
						engelx = scan34.nextInt();
						Scanner scan35 = new Scanner(System.in);
						System.out.println("Engel Y  : ");
						engely = scan35.nextInt();
						engel_diziy[i] = engely;
						engel_dizix[i] = engelx;
						gr.kullanici(engelx, engely);
						squares[engelx - 1][engely - 1].setIcon(engel);
					}

					int y = 0;

					Scanner scan3 = new Scanner(System.in);
					System.out.println("Sağa doğru kaç birim gidicek : ");
					c = scan3.nextInt();
					if (b + c > 20) {
						System.out.println("Alan dışı SOn konum ");
						squares[a - 1][19].setIcon(gezginmanip);
						System.out.println("gecme sayisi " + gecme_sayisi);

					}

					else if (b - 1 + c < 20) {

						for (int i = 0; i < kacengel; i++) {

							if ((b + c == engel_diziy[i] || b + c >= engel_diziy[i]) && b < engel_diziy[i]
									&& a == engel_dizix[i]) {
								System.out.println((i + 1) + ".engeli x ekseninde " + ((b - 1 + c) - engel_diziy[i])
										+ " birim geçtiniz ");
								gecme_sayisi += 1;

							}

							else {

							}

						}

						Scanner scan5 = new Scanner(System.in);
						System.out.println("Sola doğru kaç birim gidicek : ");
						d = scan5.nextInt();

						if (b - d + c < 1) {
							System.out.println("Alan dışı Son konum : ");
							squares[a - 1][0].setIcon(gezginmanip);

						}

						else if (b - d + c >= 1) {

							for (int i = 0; i < kacengel; i++) {
								if ((b + c - d == engel_diziy[i] || b + c - d <= engel_diziy[i])
										&& (b < engel_diziy[i] || b > engel_diziy[i]) && a == engel_dizix[i]) {
									System.out.println((i + 1) + ".engeli x ekseninde "
											+ (engel_diziy[i] - (b - 1 + c - d)) + " birim geçtiniz ");
									gecme_sayisi += 1;

								}

								else {

								}

							}

							Scanner scan6 = new Scanner(System.in);
							System.out.println("Yukari doğru kaç birim gidicek : ");
							e = scan6.nextInt();

							if (a - e < 1) {
								System.out.println("Alan dışı Son konum. ");
								squares[0][b - 1 - d + c].setIcon(gezginmanip);
								System.out.println("gecme sayisi " + gecme_sayisi);

							}

							else if (a - e >= 1) {

								for (int i = 0; i < kacengel; i++) {

									if (engel_dizix[i] >= a - e && b - d + c == engel_diziy[i] && engel_dizix[i] < a) {
										System.out.println((i + 1) + ".engeli y ekseninde " + (engel_dizix[i] - (a - e))
												+ " birim geçtiniz ");
										gecme_sayisi += 1;

									}

									else {

									}

								}

								Scanner scan7 = new Scanner(System.in);
								System.out.println("Aşağı doğru kaç birim gidicek : ");
								f = scan7.nextInt();

								if (a + f - e > 20) {
									System.out.println("Alan dışı Son konum");
									squares[19][b - 1 - d + c].setIcon(gezginmanip);
									System.out.println("gecme sayisi " + gecme_sayisi);

								}

								else if (a - e - 1 + f < 20) {

									System.out.println("Son konum");
									squares[a - 1 - e + f][b - 1 - d + c].setIcon(gezginmanip);

									for (int i = 0; i < kacengel; i++) {

										if (engel_dizix[i] <= a - e + f && b - d + c == engel_diziy[i]
												&& engel_dizix[i] > a) {
											System.out.println((i + 1) + ".engeli y ekseninde "
													+ ((a - e + f) - engel_dizix[i]) + " birim geçtiniz ");
											gecme_sayisi += 1;

										}

										else {

										}

									}
									System.out.println("gecme sayisi " + gecme_sayisi);

								}
								// HEDEFE ULAŞMA KONTROLÜ
								// 2.KISIM

								if ((a - 1 + f - e == sabitnoktax - 1) && (b - 1 - d + c == sabitnoktay - 1)) {
									System.out.println("Sabit Noktaya Ulaştınız : ");

									System.out.println("GezginManip robot kol uzunluğu : " + gm.getKoluzunlugu());

									Scanner scan9 = new Scanner(System.in);
									System.out.println("Sağa doğru kaç birim gidecek");
									sag = scan9.nextInt();

									if (b - 1 - d + c + sag > 20) {
										System.out.println("Alan dışı SOn konum ");
										squares[a - 1 + f - e][19].setIcon(yuk);

									}

									else if (b - 1 - d + c + sag < 20) {

										if (gm.getKoluzunlugu() < (sag * 10)) {

											System.out.println(
													" Kol uzunluğu  kısa olduğu için daha fazla hareket edemez Son Konum : ");
											squares[a - 1 + f - e][b - 1 - d + c + (gm.getKoluzunlugu() / 10)]
													.setIcon(yuk);

										}

										else {

											Scanner scan55 = new Scanner(System.in);
											System.out.println("Sola doğru kaç birim gidicek : ");
											sol = scan55.nextInt();

											if (b - 1 - d + c + sag - sol < 1) {
												System.out.println("Alan  dışı Son konum : ");
												squares[a - 1 + f - e][0].setIcon(yuk);

											}

											else if (b - 1 - d + c + sag - sol >= 1) {

												if ((gm.getKoluzunlugu() - sag * 10) < (sol * 10)) {

													System.out.println(
															" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
													squares[a - 1 + f - e][b - 1 - d + c
															- (gm.getKoluzunlugu() / 10 - sag) + sag].setIcon(yuk);

												}

												else {

													Scanner scan66 = new Scanner(System.in);
													System.out.println("Yukari doğru kaç birim gidicek : ");
													yukari = scan66.nextInt();

													if (a - 1 + f - e - yukari < 1) {
														System.out.println("Alan dışına çıktınız Sonn konum. ");
														squares[0][b - 1 - d + c + sag - sol].setIcon(yuk);

													}

													else if (a - 1 + f - e - yukari >= 1) {

														if ((gm.getKoluzunlugu() - (sag * 10) - (sol * 10)) < (yukari
																* 10)) {

															System.out.println(
																	" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
															squares[a - 1 + f - e
																	- (gm.getKoluzunlugu() / 10 - (sag + sol))][b - 1
																			+ c - d + sag - sol].setIcon(yuk);

														}

														else {

															Scanner scan77 = new Scanner(System.in);
															System.out.println("Aşağı doğru kaç birim gidicek : ");
															asagi = scan77.nextInt();

															if (a - 1 + f - e - yukari + asagi > 20) {
																System.out.println("Alan dışına çıktınız Son konum");
																squares[19][b - 1 - d + c + sag - sol].setIcon(yuk);

															}

															else if (a - 1 + f - e - yukari + asagi < 20) {

																if ((gm.getKoluzunlugu() - (sag * 10) - (sol * 10)
																		- (yukari * 10)) < (asagi * 10)) {

																	System.out.println(
																			" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
																	squares[a - 1 + f - e - yukari
																			+ (gm.getKoluzunlugu() / 10
																					- (sag + sol + yukari))][b - 1 + c
																							- d + sag - sol]
																									.setIcon(yuk);

																}

																else {

																	System.out.println(
																			"Girilen değerler sonucunda ki son konumunuz");
																	squares[a - 1 + f - e - yukari + asagi][b - 1 + c
																			- d + sag - sol].setIcon(yuk);

																	if ((a - 1 + f - e - yukari + asagi == hedefx - 1)
																			&& (b - 1 + c - d + sag - sol == hedefy
																					- 1)) {
																		System.out.println(
																				"Tebrikler Hedefe Ulaştınız : ");
																	}

																	else {
																		System.out.println("Hedefe Ulaşamadınız : ");
																	}

																}

															}

														}

													}

												}

											}

										}

									}

								}

								else {
									System.out.println("Sabit Noktaya Ulaşamadınız : ");
								}

								System.out.println("Engelden gecme sayisi " + gecme_sayisi);
								

							}

						}

					}
					double gezinme_suresi=0,engelden_gecme_suresi=0,koldolasma_suresi=0;
					gezinme_suresi = (gm.getgezinmehizi()) / ((c + d + e + f) * 10);
					engelden_gecme_suresi = gecme_sayisi * gm.engeldengecmesuresibul() * 3;
					koldolasma_suresi = (gm.gettasinmahizi()) / ((sag + sol + yukari + asagi) * 10);

					System.out.println("Engelden geçme suresi  : " + (engelden_gecme_suresi));
					System.out.println("Gezinme suresı suresi : " + (gezinme_suresi));
					System.out.println("Kol dolasma suresi  : " + (koldolasma_suresi));
					System.out.println("Toplamda Harcanan Sure : " + (gezinme_suresi + koldolasma_suresi
							+ engelden_gecme_suresi + gm.getSabitlemesuresi()));

				} else if (robotbilgileri[secmedegeri - 1].contains("plpar")) {
					System.out.println(robotbilgileri[secmedegeri - 1]);
					String[] parse = robotbilgileri[secmedegeri - 1].split(" ");

					main gr = new main();
					gr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					int a, b, c=0, d=0, e=0, f=0, g, h, engelx = 0, engely = 0, hedefx, hedefy, kacengel, sabitnoktax,
							sabitnoktay, sag = 0, sol = 0, yukari = 0, asagi = 0, gecme_sayisi = 0;

					Scanner scan = new Scanner(System.in);
					System.out.println("Başlangıç X  : ");
					a = scan.nextInt();
					Scanner scan2 = new Scanner(System.in);
					System.out.println("Başlangıç Y  : ");
					b = scan2.nextInt();
					gr.kullanici(a, b);
					squares[a - 1][b - 1].setIcon(gezginmanip);

					Scanner scan21 = new Scanner(System.in);
					System.out.println("Sabit nokta X  : ");
					sabitnoktax = scan2.nextInt();
					Scanner scan22 = new Scanner(System.in);
					System.out.println("Sabit Nokta Y  : ");
					sabitnoktay = scan22.nextInt();
					gr.kullanici(sabitnoktax, sabitnoktay);
					squares[sabitnoktax - 1][sabitnoktay - 1].setIcon(sabit);

					Scanner scan95 = new Scanner(System.in);
					System.out.println("Hedef X  : ");
					hedefx = scan95.nextInt();
					Scanner scan99 = new Scanner(System.in);
					System.out.println("Hedef Y  : ");
					hedefy = scan99.nextInt();
					gr.kullanici(hedefx, hedefy);
					squares[hedefx - 1][hedefy - 1].setIcon(hedef);

					Scanner scan75 = new Scanner(System.in);
					System.out.println("Kaç Engel Girmek istersiniz : ");
					kacengel = scan75.nextInt();
					int[] engel_diziy = new int[kacengel];
					int[] engel_dizix = new int[kacengel];

					for (int i = 0; i < kacengel; i++) {
						Scanner scan34 = new Scanner(System.in);
						System.out.println("Engel X  : ");
						engelx = scan34.nextInt();
						Scanner scan35 = new Scanner(System.in);
						System.out.println("Engel Y  : ");
						engely = scan35.nextInt();
						engel_diziy[i] = engely;
						engel_dizix[i] = engelx;
						gr.kullanici(engelx, engely);
						squares[engelx - 1][engely - 1].setIcon(engel);
					}

					int y = 0;

					Scanner scan3 = new Scanner(System.in);
					System.out.println("Sağa doğru kaç birim gidicek : ");
					c = scan3.nextInt();
					if (b + c > 20) {
						System.out.println("Alan dışı SOn konum ");
						squares[a - 1][19].setIcon(gezginmanip);
						System.out.println("gecme sayisi " + gecme_sayisi);

					}

					else if (b - 1 + c < 20) {

						for (int i = 0; i < kacengel; i++) {

							if ((b + c == engel_diziy[i] || b + c >= engel_diziy[i]) && b < engel_diziy[i]
									&& a == engel_dizix[i]) {
								System.out.println((i + 1) + ".engeli x ekseninde " + ((b - 1 + c) - engel_diziy[i])
										+ " birim geçtiniz ");
								gecme_sayisi += 1;

							}

							else {

							}

						}

						Scanner scan5 = new Scanner(System.in);
						System.out.println("Sola doğru kaç birim gidicek : ");
						d = scan5.nextInt();

						if (b - d + c < 1) {
							System.out.println("Alan dışı Son konum : ");
							squares[a - 1][0].setIcon(gezginmanip);

						}

						else if (b - d + c >= 1) {

							for (int i = 0; i < kacengel; i++) {
								if ((b + c - d == engel_diziy[i] || b + c - d <= engel_diziy[i])
										&& (b < engel_diziy[i] || b > engel_diziy[i]) && a == engel_dizix[i]) {
									System.out.println((i + 1) + ".engeli x ekseninde "
											+ (engel_diziy[i] - (b - 1 + c - d)) + " birim geçtiniz ");
									gecme_sayisi += 1;

								}

								else {

								}

							}

							Scanner scan6 = new Scanner(System.in);
							System.out.println("Yukari doğru kaç birim gidicek : ");
							e = scan6.nextInt();

							if (a - e < 1) {
								System.out.println("Alan dışı Son konum. ");
								squares[0][b - 1 - d + c].setIcon(gezginmanip);
								System.out.println("gecme sayisi " + gecme_sayisi);

							}

							else if (a - e >= 1) {

								for (int i = 0; i < kacengel; i++) {

									if (engel_dizix[i] >= a - e && b - d + c == engel_diziy[i] && engel_dizix[i] < a) {
										System.out.println((i + 1) + ".engeli y ekseninde " + (engel_dizix[i] - (a - e))
												+ " birim geçtiniz ");
										gecme_sayisi += 1;

									}

									else {

									}

								}

								Scanner scan7 = new Scanner(System.in);
								System.out.println("Aşağı doğru kaç birim gidicek : ");
								f = scan7.nextInt();

								if (a + f - e > 20) {
									System.out.println("Alan dışı Son konum");
									squares[19][b - 1 - d + c].setIcon(gezginmanip);
									System.out.println("gecme sayisi " + gecme_sayisi);

								}

								else if (a - e - 1 + f < 20) {

									System.out.println("Son konum");
									squares[a - 1 - e + f][b - 1 - d + c].setIcon(gezginmanip);

									for (int i = 0; i < kacengel; i++) {

										if (engel_dizix[i] <= a - e + f && b - d + c == engel_diziy[i]
												&& engel_dizix[i] > a) {
											System.out.println((i + 1) + ".engeli y ekseninde "
													+ ((a - e + f) - engel_dizix[i]) + " birim geçtiniz ");
											gecme_sayisi += 1;

										}

										else {

										}

									}
									System.out.println("gecme sayisi " + gecme_sayisi);

								}
								// HEDEFE ULAŞMA KONTROLÜ
								// 2.KISIM

								if ((a - 1 + f - e == sabitnoktax - 1) && (b - 1 - d + c == sabitnoktay - 1)) {
									System.out.println("Sabit Noktaya Ulaştınız : ");

									System.out.println("GezginManip robot kol uzunluğu : " + gm.getKoluzunlugu());

									Scanner scan9 = new Scanner(System.in);
									System.out.println("Sağa doğru kaç birim gidecek");
									sag = scan9.nextInt();

									if (b - 1 - d + c + sag > 20) {
										System.out.println("Alan dışı SOn konum ");
										squares[a - 1 + f - e][19].setIcon(yuk);

									}

									else if (b - 1 - d + c + sag < 20) {

										if (gm.getKoluzunlugu() < (sag * 10)) {

											System.out.println(
													" Kol uzunluğu  kısa olduğu için daha fazla hareket edemez Son Konum : ");
											squares[a - 1 + f - e][b - 1 - d + c + (gm.getKoluzunlugu() / 10)]
													.setIcon(yuk);

										}

										else {

											Scanner scan55 = new Scanner(System.in);
											System.out.println("Sola doğru kaç birim gidicek : ");
											sol = scan55.nextInt();

											if (b - 1 - d + c + sag - sol < 1) {
												System.out.println("Alan  dışı Son konum : ");
												squares[a - 1 + f - e][0].setIcon(yuk);

											}

											else if (b - 1 - d + c + sag - sol >= 1) {

												if ((gm.getKoluzunlugu() - sag * 10) < (sol * 10)) {

													System.out.println(
															" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
													squares[a - 1 + f - e][b - 1 - d + c
															- (gm.getKoluzunlugu() / 10 - sag) + sag].setIcon(yuk);

												}

												else {

													Scanner scan66 = new Scanner(System.in);
													System.out.println("Yukari doğru kaç birim gidicek : ");
													yukari = scan66.nextInt();

													if (a - 1 + f - e - yukari < 1) {
														System.out.println("Alan dışına çıktınız Sonn konum. ");
														squares[0][b - 1 - d + c + sag - sol].setIcon(yuk);

													}

													else if (a - 1 + f - e - yukari >= 1) {

														if ((gm.getKoluzunlugu() - (sag * 10) - (sol * 10)) < (yukari
																* 10)) {

															System.out.println(
																	" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
															squares[a - 1 + f - e
																	- (gm.getKoluzunlugu() / 10 - (sag + sol))][b - 1
																			+ c - d + sag - sol].setIcon(yuk);

														}

														else {

															Scanner scan77 = new Scanner(System.in);
															System.out.println("Aşağı doğru kaç birim gidicek : ");
															asagi = scan77.nextInt();

															if (a - 1 + f - e - yukari + asagi > 20) {
																System.out.println("Alan dışına çıktınız Son konum");
																squares[19][b - 1 - d + c + sag - sol].setIcon(yuk);

															}

															else if (a - 1 + f - e - yukari + asagi < 20) {

																if ((gm.getKoluzunlugu() - (sag * 10) - (sol * 10)
																		- (yukari * 10)) < (asagi * 10)) {

																	System.out.println(
																			" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
																	squares[a - 1 + f - e - yukari
																			+ (gm.getKoluzunlugu() / 10
																					- (sag + sol + yukari))][b - 1 + c
																							- d + sag - sol]
																									.setIcon(yuk);

																}

																else {

																	System.out.println(
																			"Girilen değerler sonucunda ki son konumunuz");
																	squares[a - 1 + f - e - yukari + asagi][b - 1 + c
																			- d + sag - sol].setIcon(yuk);

																	if ((a - 1 + f - e - yukari + asagi == hedefx - 1)
																			&& (b - 1 + c - d + sag - sol == hedefy
																					- 1)) {
																		System.out.println(
																				"Tebrikler Hedefe Ulaştınız : ");
																	}

																	else {
																		System.out.println("Hedefe Ulaşamadınız : ");
																	}

																}

															}

														}

													}

												}

											}

										}

									}

								}

								else {
									System.out.println("Sabit Noktaya Ulaşamadınız : ");
								}

								System.out.println("Engelden gecme sayisi " + gecme_sayisi);
								

							}

						}

					}
					
					double gezinme_suresi=0,engelden_gecme_suresi=0,koldolasma_suresi=0;
					gezinme_suresi = (gm.getgezinmehizi()) / ((c + d + e + f) * 10);
					engelden_gecme_suresi = gecme_sayisi * gm.engeldengecmesuresibul() * 3;
					koldolasma_suresi = (gm.gettasinmahizi()) / ((sag + sol + yukari + asagi) * 10);

					System.out.println("Engelden geçme suresi  : " + (engelden_gecme_suresi));
					System.out.println("Gezinme suresı suresi : " + (gezinme_suresi));
					System.out.println("Kol dolasma suresi  : " + (koldolasma_suresi));
					System.out.println("Toplamda Harcanan Sure : " + (gezinme_suresi + koldolasma_suresi
							+ engelden_gecme_suresi + gm.getSabitlemesuresi()));

				} else if (robotbilgileri[secmedegeri - 1].contains("sipser")) {
					System.out.println(robotbilgileri[secmedegeri - 1]);
					String[] parse = robotbilgileri[secmedegeri - 1].split(" ");
					
					main gr = new main();
					gr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					int a, b, c=0, d=0, e=0, f=0, g, h, engelx = 0, engely = 0, hedefx, hedefy, kacengel, sabitnoktax, sabitnoktay, sag = 0,
							sol = 0, yukari = 0, asagi = 0, gecme_sayisi = 0;

					Scanner scan = new Scanner(System.in);
					System.out.println("Başlangıç X  : ");
					a = scan.nextInt();
					Scanner scan2 = new Scanner(System.in);
					System.out.println("Başlangıç Y  : ");
					b = scan2.nextInt();
					gr.kullanici(a, b);
					squares[a - 1][b - 1].setIcon(gezginmanip);

					Scanner scan21 = new Scanner(System.in);
					System.out.println("Sabit nokta X  : ");
					sabitnoktax = scan2.nextInt();
					Scanner scan22 = new Scanner(System.in);
					System.out.println("Sabit Nokta Y  : ");
					sabitnoktay = scan22.nextInt();
					gr.kullanici(sabitnoktax, sabitnoktay);
					squares[sabitnoktax - 1][sabitnoktay - 1].setIcon(sabit);

					Scanner scan95 = new Scanner(System.in);
					System.out.println("Hedef X  : ");
					hedefx = scan95.nextInt();
					Scanner scan99 = new Scanner(System.in);
					System.out.println("Hedef Y  : ");
					hedefy = scan99.nextInt();
					gr.kullanici(hedefx, hedefy);
					squares[hedefx - 1][hedefy - 1].setIcon(hedef);

					Scanner scan75 = new Scanner(System.in);
					System.out.println("Kaç Engel Girmek istersiniz : ");
					kacengel = scan75.nextInt();
					int[] engel_diziy = new int[kacengel];
					int[] engel_dizix = new int[kacengel];

					for (int i = 0; i < kacengel; i++) {
						Scanner scan34 = new Scanner(System.in);
						System.out.println("Engel X  : ");
						engelx = scan34.nextInt();
						Scanner scan35 = new Scanner(System.in);
						System.out.println("Engel Y  : ");
						engely = scan35.nextInt();
						engel_diziy[i] = engely;
						engel_dizix[i] = engelx;
						gr.kullanici(engelx, engely);
						squares[engelx - 1][engely - 1].setIcon(engel);
					}

					Scanner scan3 = new Scanner(System.in);
					System.out.println("Sağa doğru kaç birim gidicek : ");
					c = scan3.nextInt();
					if (b + c > 20) {

						System.out.println("Alan dışına çıktınız. SOn konum ");
						squares[a - 1][19].setIcon(gezginmanip);

					}

					else if (b - 1 + c < 20) {

						for (int i = 0; i < kacengel; i++) {

							while (engel_diziy[i] <= b + c && a == engel_dizix[i] && engel_diziy[i] > b) {

								System.out.println("Engelden gecemessiniz : ");

								System.out.println("SOn konum ");
								squares[a - 1][engel_diziy[i] - 2].setIcon(gezginmanip);
								c = scan3.nextInt();
								double dolasma_suresi = (gm.getgezinmehizi()) / ((engel_diziy[i] - 2) * 10);
								System.out.println("Toplamda Harcanan Sure : " + (dolasma_suresi));
								System.exit(1);

								break;

							}

						}

						Scanner scan5 = new Scanner(System.in);
						System.out.println("Sola doğru kaç birim gidicek : ");
						d = scan5.nextInt();

						if (b - d + c < 1) {
							System.out.println("Alandan Çıktınız Son konum : ");
							squares[a - 1][0].setIcon(gezginmanip);

						}

						else if (b - d + c >= 1) {

							for (int i = 0; i < kacengel; i++) {
								while (engel_diziy[i] >= b + c - d && a == engel_dizix[i] && engel_diziy[i] < b) {
									System.out.println("Engelden gecemessiniz : ");

									System.out.println("SOn konum ");
									squares[a - 1][engel_diziy[i]].setIcon(gezginmanip);
									double dolasma_suresi = (gm.getgezinmehizi()) / ((engel_diziy[i] + c) * 10);
									System.out.println("Toplamda Harcanan Sure : " + (dolasma_suresi));

									c = scan3.nextInt();
									System.exit(1);

									break;

								}

							}

							Scanner scan6 = new Scanner(System.in);
							System.out.println("Yukari doğru kaç birim gidicek : ");
							e = scan6.nextInt();

							if (a - e < 1) {
								System.out.println("Alandan çıktınız Sonn konum. ");
								squares[0][b - 1 - d + c].setIcon(gezginmanip);

							}

							else if (a - e >= 1) {

								for (int i = 0; i < kacengel; i++) {
									while (engel_dizix[i] >= a - e && b - d + c == engel_diziy[i] && engel_dizix[i] < a) {
										System.out.println("Engelden gecemessiniz : ");

										System.out.println("SOn konum ");
										squares[engel_dizix[i]][b - 1 - d + c].setIcon(gezginmanip);
										double dolasma_suresi = (gm.getgezinmehizi()) / ((b + c + engel_dizix[i]) * 10);
										System.out.println("Toplamda Harcanan Sure : " + (dolasma_suresi));

										c = scan3.nextInt();
										System.exit(1);

										break;

									}

								}

								Scanner scan7 = new Scanner(System.in);
								System.out.println("Aşağı doğru kaç birim gidicek : ");
								f = scan7.nextInt();

								if (a + f - e > 20) {
									System.out.println("Alandan Çıktınız Son konum");
									squares[19][b - 1 - d + c].setIcon(gezginmanip);

								}

								else if (a - e - 1 + f < 20) {

									for (int i = 0; i < kacengel; i++) {
										while (engel_dizix[i] <= a - e + f && b - d + c == engel_diziy[i] && engel_dizix[i] > a) {
											System.out.println("Engelden gecemessiniz : ");

											System.out.println("SOn konum ");
											squares[engel_dizix[i] - 2][b - 1 - d + c].setIcon(gezginmanip);
											double dolasma_suresi = (gm.getgezinmehizi()) / ((b + c + d + engel_dizix[i] - 2) * 10);
											System.out.println("Toplamda Harcanan Sure : " + (dolasma_suresi));

											c = scan3.nextInt();
											System.exit(1);

											break;

										}

									}
									squares[a - 1 - e + f][b - 1 - d + c].setIcon(gezginmanip);

								}
								// HEDEFE ULAŞMA KONTROLÜ

								if ((a - 1 + f - e == sabitnoktax - 1) && (b - 1 - d + c == sabitnoktay - 1)) {

									System.out.println("Sabit Noktaya Ulaştınız \n");

									System.out.println("GezginManip robot kol uzunluğu : " + gm.getKoluzunlugu());

									Scanner scan9 = new Scanner(System.in);
									System.out.println("Sağa doğru kaç birim gidecek");
									sag = scan9.nextInt();

									if (b - 1 - d + c + sag > 20) {
										System.out.println("Alan dışı SOn konum ");
										squares[a - 1 + f - e][19].setIcon(yuk);

									}

									else if (b - 1 - d + c + sag < 20) {

										if (gm.getKoluzunlugu() < (sag * 10)) {

											System.out.println(
													" Kol uzunluğu  kısa olduğu için daha fazla hareket edemez Son Konum : ");
											squares[a - 1 + f - e][b - 1 - d + c + (gm.getKoluzunlugu() / 10)].setIcon(yuk);

										}

										else {

											Scanner scan55 = new Scanner(System.in);
											System.out.println("Sola doğru kaç birim gidicek : ");
											sol = scan55.nextInt();

											if (b - 1 - d + c + sag - sol < 1) {
												System.out.println("Alan  dışı Son konum : ");
												squares[a - 1 + f - e][0].setIcon(yuk);

											}

											else if (b - 1 - d + c + sag - sol >= 1) {

												if ((gm.getKoluzunlugu() - sag * 10) < (sol * 10)) {

													System.out.println(
															" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
													squares[a - 1 + f - e][b - 1 - d + c - (gm.getKoluzunlugu() / 10 - sag) + sag]
															.setIcon(yuk);

												}

												else {

													Scanner scan66 = new Scanner(System.in);
													System.out.println("Yukari doğru kaç birim gidicek : ");
													yukari = scan66.nextInt();

													if (a - 1 + f - e - yukari < 1) {
														System.out.println("Alan dışına çıktınız Sonn konum. ");
														squares[0][b - 1 - d + c + sag - sol].setIcon(yuk);

													}

													else if (a - 1 + f - e - yukari >= 1) {

														if ((gm.getKoluzunlugu() - (sag * 10) - (sol * 10)) < (yukari * 10)) {

															System.out.println(
																	" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
															squares[a - 1 + f - e - (gm.getKoluzunlugu() / 10 - (sag + sol))][b - 1
																	+ c - d + sag - sol].setIcon(yuk);

														}

														else {

															Scanner scan77 = new Scanner(System.in);
															System.out.println("Aşağı doğru kaç birim gidicek : ");
															asagi = scan77.nextInt();

															if (a - 1 + f - e - yukari + asagi > 20) {
																System.out.println("Alan dışına çıktınız Son konum");
																squares[19][b - 1 - d + c + sag - sol].setIcon(yuk);

															}

															else if (a - 1 + f - e - yukari + asagi < 20) {

																if ((gm.getKoluzunlugu() - (sag * 10) - (sol * 10)
																		- (yukari * 10)) < (asagi * 10)) {

																	System.out.println(
																			" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
																	squares[a - 1 + f - e - yukari
																			+ (gm.getKoluzunlugu() / 10 - (sag + sol + yukari))][b
																					- 1 + c - d + sag - sol].setIcon(yuk);

																}

																else {

																	System.out
																			.println("Girilen değerler sonucunda ki son konumunuz");
																	squares[a - 1 + f - e - yukari + asagi][b - 1 + c - d + sag
																			- sol].setIcon(yuk);

																	if ((a - 1 + f - e - yukari + asagi == hedefx - 1)
																			&& (b - 1 + c - d + sag - sol == hedefy - 1)) {
																		System.out.println("Tebrikler Hedefe Ulaştınız : ");
																	}

																	else {
																		System.out.println("Hedefe Ulaşamadınız : ");
																	}

																}

															}

														}

													}

												}

											}

										}

									}

								}

								else {
									System.out.println("Sabit Noktaya Ulaşamadınız : ");
								}

							
								
							}

						}
						


					}
					
					double gezinme_suresi=0,engelden_gecme_suresi=0,koldolasma_suresi=0;
					gezinme_suresi = (gm.getgezinmehizi()) / ((c + d + e + f) * 10);
					koldolasma_suresi = (gm.gettasinmahizi()) / ((sag + sol + yukari + asagi) * 10);

					
					System.out.println("Gezinme suresı suresi : " + (gezinme_suresi));
					System.out.println("Kol dolasma suresi  : " + (koldolasma_suresi));
					System.out.println("Toplamda Harcanan Sure : " + (gezinme_suresi + koldolasma_suresi
							 + gm.getSabitlemesuresi()));

				} else if (robotbilgileri[secmedegeri - 1].contains("sppar")) {
					System.out.println(robotbilgileri[secmedegeri - 1]);
					String[] parse = robotbilgileri[secmedegeri - 1].split(" ");
					
					main gr = new main();
					gr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					int a, b, c=0, d=0, e=0, f=0, g, h, engelx = 0, engely = 0, hedefx, hedefy, kacengel, sabitnoktax, sabitnoktay, sag = 0,
							sol = 0, yukari = 0, asagi = 0, gecme_sayisi = 0;

					Scanner scan = new Scanner(System.in);
					System.out.println("Başlangıç X  : ");
					a = scan.nextInt();
					Scanner scan2 = new Scanner(System.in);
					System.out.println("Başlangıç Y  : ");
					b = scan2.nextInt();
					gr.kullanici(a, b);
					squares[a - 1][b - 1].setIcon(gezginmanip);

					Scanner scan21 = new Scanner(System.in);
					System.out.println("Sabit nokta X  : ");
					sabitnoktax = scan2.nextInt();
					Scanner scan22 = new Scanner(System.in);
					System.out.println("Sabit Nokta Y  : ");
					sabitnoktay = scan22.nextInt();
					gr.kullanici(sabitnoktax, sabitnoktay);
					squares[sabitnoktax - 1][sabitnoktay - 1].setIcon(sabit);

					Scanner scan95 = new Scanner(System.in);
					System.out.println("Hedef X  : ");
					hedefx = scan95.nextInt();
					Scanner scan99 = new Scanner(System.in);
					System.out.println("Hedef Y  : ");
					hedefy = scan99.nextInt();
					gr.kullanici(hedefx, hedefy);
					squares[hedefx - 1][hedefy - 1].setIcon(hedef);

					Scanner scan75 = new Scanner(System.in);
					System.out.println("Kaç Engel Girmek istersiniz : ");
					kacengel = scan75.nextInt();
					int[] engel_diziy = new int[kacengel];
					int[] engel_dizix = new int[kacengel];

					for (int i = 0; i < kacengel; i++) {
						Scanner scan34 = new Scanner(System.in);
						System.out.println("Engel X  : ");
						engelx = scan34.nextInt();
						Scanner scan35 = new Scanner(System.in);
						System.out.println("Engel Y  : ");
						engely = scan35.nextInt();
						engel_diziy[i] = engely;
						engel_dizix[i] = engelx;
						gr.kullanici(engelx, engely);
						squares[engelx - 1][engely - 1].setIcon(engel);
					}

					Scanner scan3 = new Scanner(System.in);
					System.out.println("Sağa doğru kaç birim gidicek : ");
					c = scan3.nextInt();
					if (b + c > 20) {

						System.out.println("Alan dışına çıktınız. SOn konum ");
						squares[a - 1][19].setIcon(gezginmanip);

					}

					else if (b - 1 + c < 20) {

						for (int i = 0; i < kacengel; i++) {

							while (engel_diziy[i] <= b + c && a == engel_dizix[i] && engel_diziy[i] > b) {

								System.out.println("Engelden gecemessiniz : ");

								System.out.println("SOn konum ");
								squares[a - 1][engel_diziy[i] - 2].setIcon(gezginmanip);
								c = scan3.nextInt();
								double dolasma_suresi = (gm.getgezinmehizi()) / ((engel_diziy[i] - 2) * 10);
								System.out.println("Toplamda Harcanan Sure : " + (dolasma_suresi));
								System.exit(1);

								break;

							}

						}

						Scanner scan5 = new Scanner(System.in);
						System.out.println("Sola doğru kaç birim gidicek : ");
						d = scan5.nextInt();

						if (b - d + c < 1) {
							System.out.println("Alandan Çıktınız Son konum : ");
							squares[a - 1][0].setIcon(gezginmanip);

						}

						else if (b - d + c >= 1) {

							for (int i = 0; i < kacengel; i++) {
								while (engel_diziy[i] >= b + c - d && a == engel_dizix[i] && engel_diziy[i] < b) {
									System.out.println("Engelden gecemessiniz : ");

									System.out.println("SOn konum ");
									squares[a - 1][engel_diziy[i]].setIcon(gezginmanip);
									double dolasma_suresi = (gm.getgezinmehizi()) / ((engel_diziy[i] + c) * 10);
									System.out.println("Toplamda Harcanan Sure : " + (dolasma_suresi));

									c = scan3.nextInt();
									System.exit(1);

									break;

								}

							}

							Scanner scan6 = new Scanner(System.in);
							System.out.println("Yukari doğru kaç birim gidicek : ");
							e = scan6.nextInt();

							if (a - e < 1) {
								System.out.println("Alandan çıktınız Sonn konum. ");
								squares[0][b - 1 - d + c].setIcon(gezginmanip);

							}

							else if (a - e >= 1) {

								for (int i = 0; i < kacengel; i++) {
									while (engel_dizix[i] >= a - e && b - d + c == engel_diziy[i] && engel_dizix[i] < a) {
										System.out.println("Engelden gecemessiniz : ");

										System.out.println("SOn konum ");
										squares[engel_dizix[i]][b - 1 - d + c].setIcon(gezginmanip);
										double dolasma_suresi = (gm.getgezinmehizi()) / ((b + c + engel_dizix[i]) * 10);
										System.out.println("Toplamda Harcanan Sure : " + (dolasma_suresi));

										c = scan3.nextInt();
										System.exit(1);

										break;

									}

								}

								Scanner scan7 = new Scanner(System.in);
								System.out.println("Aşağı doğru kaç birim gidicek : ");
								f = scan7.nextInt();

								if (a + f - e > 20) {
									System.out.println("Alandan Çıktınız Son konum");
									squares[19][b - 1 - d + c].setIcon(gezginmanip);

								}

								else if (a - e - 1 + f < 20) {

									for (int i = 0; i < kacengel; i++) {
										while (engel_dizix[i] <= a - e + f && b - d + c == engel_diziy[i] && engel_dizix[i] > a) {
											System.out.println("Engelden gecemessiniz : ");

											System.out.println("SOn konum ");
											squares[engel_dizix[i] - 2][b - 1 - d + c].setIcon(gezginmanip);
											double dolasma_suresi = (gm.getgezinmehizi()) / ((b + c + d + engel_dizix[i] - 2) * 10);
											System.out.println("Toplamda Harcanan Sure : " + (dolasma_suresi));

											c = scan3.nextInt();
											System.exit(1);

											break;

										}

									}
									squares[a - 1 - e + f][b - 1 - d + c].setIcon(gezginmanip);

								}
								// HEDEFE ULAŞMA KONTROLÜ

								if ((a - 1 + f - e == sabitnoktax - 1) && (b - 1 - d + c == sabitnoktay - 1)) {

									System.out.println("Sabit Noktaya Ulaştınız \n");

									System.out.println("GezginManip robot kol uzunluğu : " + gm.getKoluzunlugu());

									Scanner scan9 = new Scanner(System.in);
									System.out.println("Sağa doğru kaç birim gidecek");
									sag = scan9.nextInt();

									if (b - 1 - d + c + sag > 20) {
										System.out.println("Alan dışı SOn konum ");
										squares[a - 1 + f - e][19].setIcon(yuk);

									}

									else if (b - 1 - d + c + sag < 20) {

										if (gm.getKoluzunlugu() < (sag * 10)) {

											System.out.println(
													" Kol uzunluğu  kısa olduğu için daha fazla hareket edemez Son Konum : ");
											squares[a - 1 + f - e][b - 1 - d + c + (gm.getKoluzunlugu() / 10)].setIcon(yuk);

										}

										else {

											Scanner scan55 = new Scanner(System.in);
											System.out.println("Sola doğru kaç birim gidicek : ");
											sol = scan55.nextInt();

											if (b - 1 - d + c + sag - sol < 1) {
												System.out.println("Alan  dışı Son konum : ");
												squares[a - 1 + f - e][0].setIcon(yuk);

											}

											else if (b - 1 - d + c + sag - sol >= 1) {

												if ((gm.getKoluzunlugu() - sag * 10) < (sol * 10)) {

													System.out.println(
															" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
													squares[a - 1 + f - e][b - 1 - d + c - (gm.getKoluzunlugu() / 10 - sag) + sag]
															.setIcon(yuk);

												}

												else {

													Scanner scan66 = new Scanner(System.in);
													System.out.println("Yukari doğru kaç birim gidicek : ");
													yukari = scan66.nextInt();

													if (a - 1 + f - e - yukari < 1) {
														System.out.println("Alan dışına çıktınız Sonn konum. ");
														squares[0][b - 1 - d + c + sag - sol].setIcon(yuk);

													}

													else if (a - 1 + f - e - yukari >= 1) {

														if ((gm.getKoluzunlugu() - (sag * 10) - (sol * 10)) < (yukari * 10)) {

															System.out.println(
																	" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
															squares[a - 1 + f - e - (gm.getKoluzunlugu() / 10 - (sag + sol))][b - 1
																	+ c - d + sag - sol].setIcon(yuk);

														}

														else {

															Scanner scan77 = new Scanner(System.in);
															System.out.println("Aşağı doğru kaç birim gidicek : ");
															asagi = scan77.nextInt();

															if (a - 1 + f - e - yukari + asagi > 20) {
																System.out.println("Alan dışına çıktınız Son konum");
																squares[19][b - 1 - d + c + sag - sol].setIcon(yuk);

															}

															else if (a - 1 + f - e - yukari + asagi < 20) {

																if ((gm.getKoluzunlugu() - (sag * 10) - (sol * 10)
																		- (yukari * 10)) < (asagi * 10)) {

																	System.out.println(
																			" Kol uzunluğu girdiğiniz değere yetmediği için daha fazla hareket edemez Son Konum : ");
																	squares[a - 1 + f - e - yukari
																			+ (gm.getKoluzunlugu() / 10 - (sag + sol + yukari))][b
																					- 1 + c - d + sag - sol].setIcon(yuk);

																}

																else {

																	System.out
																			.println("Girilen değerler sonucunda ki son konumunuz");
																	squares[a - 1 + f - e - yukari + asagi][b - 1 + c - d + sag
																			- sol].setIcon(yuk);

																	if ((a - 1 + f - e - yukari + asagi == hedefx - 1)
																			&& (b - 1 + c - d + sag - sol == hedefy - 1)) {
																		System.out.println("Tebrikler Hedefe Ulaştınız : ");
																	}

																	else {
																		System.out.println("Hedefe Ulaşamadınız : ");
																	}

																}

															}

														}

													}

												}

											}

										}

									}

								}

								else {
									System.out.println("Sabit Noktaya Ulaşamadınız : ");
								}

								

							}

						}

					}
					double gezinme_suresi=0,engelden_gecme_suresi=0,koldolasma_suresi=0;
					gezinme_suresi = (gm.getgezinmehizi()) / ((c + d + e + f) * 10);
					koldolasma_suresi = (gm.gettasinmahizi()) / ((sag + sol + yukari + asagi) * 10);

					
					System.out.println("Gezinme suresı suresi : " + (gezinme_suresi));
					System.out.println("Kol dolasma suresi  : " + (koldolasma_suresi));
					System.out.println("Toplamda Harcanan Sure : " + (gezinme_suresi + koldolasma_suresi
							 + gm.getSabitlemesuresi()));

				}

			} else {

			}
		}

	}

}
