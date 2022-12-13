package com.promineotech.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LIbraryBook {

	private int librarybookid_pk;
	private int libraryid_fk;
	private int booknumber_fk;
}
