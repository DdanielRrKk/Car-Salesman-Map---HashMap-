package dom10;

import java.util.LinkedHashMap;
import java.util.Scanner;


public class zad1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		LinkedHashMap<Integer,Engine>engines=new LinkedHashMap<Integer,Engine>();
		LinkedHashMap<Integer,Car>cars=new LinkedHashMap<Integer,Car>();
		String line="";
		int inside_count=0;
		
		int count=sc.nextInt();
		line=sc.nextLine();
		while(count!=inside_count) {
			line=sc.nextLine();
			String[] splitLine=line.split(" ");
			String m=splitLine[0];
			int p=Integer.parseInt(splitLine[1]);
			
			if(splitLine[1]==splitLine[splitLine.length-1]) {
				Engine eng=new Engine(m,p);
				engines.put(inside_count,eng);
			}
			else {
				int d=Integer.parseInt(splitLine[2]);
				
				if(splitLine[2]==splitLine[splitLine.length-1]) {
					Engine eng=new Engine(m,p,d);
					engines.put(inside_count,eng);
				}
				else {
					String e=splitLine[3];
					
					Engine eng=new Engine(m,p,d,e);
					engines.put(inside_count,eng);
				}
			}
			
			inside_count++;
		}
		
		for (int i = 0; i < engines.size(); i++) {
			System.out.println(engines.get(i));
		}
		
		count=sc.nextInt();
		line=sc.nextLine();
		inside_count=0;
		while(count!=inside_count) {
			line=sc.nextLine();
			String[] splitLine=line.split(" ");
			String m=splitLine[0];
			
			Engine eng=new Engine();
			String s=splitLine[1];
			for (int i = 0; i < engines.size(); i++) {
				if(s.equals(engines.get(i).getModel())) {
					Engine tempE=engines.get(i);
					eng=tempE;
					break;
				}
			}
			
			if(splitLine[1]==splitLine[splitLine.length-1]) {
				Car car=new Car(m,eng);
				cars.put(inside_count,car);
			}
			else {
				String str=splitLine[2];
				int w=0;
				
				if(isNumeric(str)) {
					w=Integer.parseInt(splitLine[2]);
				}
				
				if(splitLine[2]==splitLine[splitLine.length-1]) {
					if(isNumeric(str)) {
						w=Integer.parseInt(splitLine[2]);
						Car car=new Car(m,eng,w);
						cars.put(inside_count,car);
					}
					else {
						Car car=new Car(m,eng,str);
						cars.put(inside_count,car);
					}
				}
				else {
					String c=splitLine[3];
					
					Car car=new Car(m,eng,w,c);
					cars.put(inside_count,car);
				}
			}
			
			inside_count++;
		}
		
		for (int i = 0; i < cars.size(); i++) {
			System.out.println(cars.get(i));
		}
		
		sc.close();
	}
	
	public static boolean isNumeric(final String str) {
        if (str == null || str.length() == 0) {return false;}
        try {Integer.parseInt(str);return true;} catch (NumberFormatException e) {return false;}
    }

}

class Car{
	String model;
	Engine engine=new Engine();
	int weight;
	String color;
	
	Car(){model="n/a";weight=0;color="n/a";}
	Car(String m,Engine eng){model=m;engine=eng;}
	Car(String m,Engine eng,int w){model=m;engine=eng;weight=w;}
	Car(String m,Engine eng,String c){model=m;engine=eng;color=c;}
	Car(String m,Engine eng,int w,String c){model=m;engine=eng;weight=w;color=c;}
	
	public void setEngine(Engine eng) {engine=eng;}
	
	public String toString() {
		String str1="n/a"; String str2="n/a";
		if(weight!=0) {str1=String.valueOf(weight);}
		if(color != null) {str2=String.valueOf(color);}
		return "Model: "+model+" \n"+engine+" \n  Weight: "+str1+" \n  Color: "+str2+"\n \n";
	}
	
}

class Engine{
	String model;
	int power;
	int displacement;
	String efficiency;
	
	Engine(){model="n/a";power=0;displacement=0;efficiency="n/a";}
	Engine(String m,int p){model=m;power=p;}
	Engine(String m,int p,int d){model=m;power=p;displacement=d;}
	Engine(String m,int p,int d,String e){model=m;power=p;displacement=d;efficiency=e;}
	
	public String getModel() {return model;}
	public int getPower() {return power;}
	public int getDisplacement() {return displacement;}
	public String getEficiency() {return efficiency;}
	
	
	public String toString() {
		String str1="n/a"; String str2="n/a";
		if(displacement!=0) {str1=String.valueOf(displacement);}
		if(efficiency != null) {str2=String.valueOf(efficiency);}
		return "  "+model+": \n   Power: "+power+" \n   Displacement: "+str1+" \n   Efficiency: "+str2;
	}
	
}

