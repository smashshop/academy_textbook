package sample.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SampleDTOList {
	
	private List<SampleDTO> sampleList;
	
	public SampleDTOList() {
		this.sampleList = new ArrayList<SampleDTO>();
	}
	
}
