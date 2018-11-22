package exos;

import java.time.Period ;
import java.util.Locale ;
import java.text.DateFormatSymbols;
import java.time.LocalDate ;
import java.time.format.DateTimeFormatter; ;

public class DateExemple {

	public static void main(String[] args) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy") ;

		LocalDate date = LocalDate.of(2017, 04, 30);
		String text = date.format(formatter);
		System.out.println(text);
		LocalDate parsedDate = LocalDate.parse(text, formatter);

		System.out.println(parsedDate);
		
		LocalDate birth = LocalDate.of(1990, 01, 15) ;
		LocalDate today = LocalDate.now() ; 
	
		Period diff = Period.between(birth, today) ;
		System.out.printf("J'ai %d ans, %d mois et %d jours.", diff.getYears(), diff.getMonths(), diff.getDays());
		
		DateFormatSymbols symbols = new DateFormatSymbols(new Locale("fr")) ;
		
		for (String d : symbols.getWeekdays())
			System.out.println(d);
		LocalDate tomorrow = today.plusDays(1);
		System.out.println(tomorrow);
		System.out.println(today.minusDays(20));
		System.out.println(today.plusDays(20));
	}
}
