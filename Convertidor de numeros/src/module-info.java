import javax.swing.JOptionPane;
import java.util.Map;
import java.util.HashMap;

public class convertidor {
	public static int centenas = 0, decenas = 0, unidades = 0;
	public static String [][] romanos={{"","I","II","III","IV","V","VI","VII","VIII","IX"},
	         							{"","X","XX","XXX","XL","L","LX","LXX","LXX","XC"},
	         							{"","C"}};
	public static void main(String[] args) {
			int num,select,res;
			String rom,nr;
			select=Integer.parseInt(JOptionPane.showInputDialog("Seleccione una Opcion : \n \n  1.Convertir de Arabigo a Romano.\n 2.Convertir de Romano a Arabigo. "));
			switch(select) {
			case 1:
				num=Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero Arabigo entre 1 y 100: "));
				obtenerNotDesarrollada(num);
				rom=obtenerRomano();
				JOptionPane.showMessageDialog(null, "El numero en Romano es:"+rom, "RESULTADOS " , JOptionPane.INFORMATION_MESSAGE);
				break;
			case 2:
				nr=(JOptionPane.showInputDialog("Ingrese un numero Romano entre 1 y 100: "));
				res=arabigo(nr);
				JOptionPane.showMessageDialog(null, "El numero en Arabigo es:"+res, "RESULTADOS " , JOptionPane.INFORMATION_MESSAGE);
				break;
				
				default:
				break;
			}
	}
	
	
	
	public static void obtenerNotDesarrollada(int numero) {
	      centenas = (int)numero % 1000 / 100;
	      decenas = (int)numero % 1000 % 100 / 10;
	      unidades = (int)numero % 1000 % 100 % 10;
	   }
	
	public static String obtenerRomano(){
	      return 
	            romanos[2][centenas]+""+
	            romanos[1][decenas]+""+
	            romanos[0][unidades]+"";
	   }
	
	public static int arabigo(String roman_numeral) {
        Map<Character, Integer> roman_char_dict = new HashMap<Character, Integer>();
        roman_char_dict.put('I', 1);
        roman_char_dict.put('V', 5);
        roman_char_dict.put('X', 10);
        roman_char_dict.put('L', 50);
        roman_char_dict.put('C', 100);
        int res1 = 0;
        for (int i = 0; i < roman_numeral.length(); i += 1) {
            if (i == 0 || roman_char_dict.get(roman_numeral.charAt(i)) <= roman_char_dict.get(roman_numeral.charAt(i - 1)))
                res1 += roman_char_dict.get(roman_numeral.charAt(i));
            else
                res1 += roman_char_dict.get(roman_numeral.charAt(i)) - 2 * roman_char_dict.get(roman_numeral.charAt(i - 1));
        }
        return res1;
    }
}

