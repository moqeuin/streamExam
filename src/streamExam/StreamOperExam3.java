package streamExam;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamOperExam3 {

	public static void main(String[] args) {
		
		Stream<String[]> strArrStrm = Stream.of(
												new String[] {"abc","ghi","def"},
												new String[] {"ABC","GHI","DEF"}
											);
		// 요소가 1차원배열(Stream<String[]>이기 때문에 1차원배열의 요소는 Stream<Stream<String>>이 되어 버린다.
		//Stream<Stream<String>> strStrmStrm = strArrStrm.map(Arrays::stream);
		
		// 2차원 배열은 flatMap을 사용해서 가져온다.
		Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);
		
		strStrm
		.map(String::toLowerCase)
		.distinct()
		.sorted()
		.forEach(System.out::println);
		/*		
			abc
			def
			ghi

		*/
		
		String[] lineArr = {
				"Believe or not It is true",
				"Do or do not There is no try",
		};
		
		Stream<String> lineStream = Arrays.stream(lineArr);
		lineStream
		.flatMap( line -> Stream.of(line.split(" +"))) // 하나 이상의 공백을 나타내는 정규식
		.distinct()
		.sorted()
		.forEach(System.out::println);
		
		/*
		 	Believe
			Do
			It
			There
			do
			is
			no
			not
			or
			true
			try
		 
		 */
	}

}
