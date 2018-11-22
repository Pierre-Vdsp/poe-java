package poe.tp.JaxB.xml;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, LocalDate> {

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Override
	public String marshal(LocalDate pV) throws Exception {
		return pV.format(this.formatter);
	}

	@Override
	public LocalDate unmarshal(String pV) throws Exception {
		return LocalDate.parse(pV, this.formatter);
	}

}
