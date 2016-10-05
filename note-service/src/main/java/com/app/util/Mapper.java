package com.app.util;

import com.app.client.Note;
import com.app.domain.NoteDTO;

public class Mapper {

	public static Note apply(NoteDTO noteDto){
		Note note = new Note();
		note.setId(String.valueOf(noteDto.getId()));
		note.setKey(noteDto.getKey());
		note.setSubject(noteDto.getSubject());
		note.setText(noteDto.getText());
		return note;
		
	}
	
}
