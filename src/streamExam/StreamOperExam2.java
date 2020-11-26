package streamExam;

import java.io.File;
import java.util.stream.Stream;

public class StreamOperExam2 {

	public static void main(String[] args) {
		
		File[] fileArr = {new File("ex1.java"), new File("ex1.bak"),
						  new File("ex2.java"), new File("ex1"), new File("ex1.txt")
							};
		
		Stream<File> fileStream = Stream.of(fileArr);
		
		// 스트림의 요소 중 특정한 요소들을 가져오거나 변환할 때 map을 사용한다. fileArr[0].getName과 같다
		Stream<String> fileNameStream = fileStream.map(File::getName);
		fileNameStream.forEach(System.out::println);
		/*
			ex1.java
			ex1.bak
			ex2.java
			ex1
			ex1.txt
		*/
		
		fileStream = Stream.of(fileArr);
		
		fileStream.map(File::getName)
		.filter(s -> s.indexOf(".") != -1) // 확장자가 없으면 제외
		.map( s -> s.substring(s.indexOf('.')+1)) // 확장자만 가져온다
		.map(String::toUpperCase)
		.distinct()
		.forEach(System.out::println);
		/*
			 JAVA
			 BAK
			 TXT
		 */
		
		fileStream = Stream.of(fileArr);
		
		
		// peek()는 중간연산된 요소를 소모하지 않고 출력할 수 있다. 
		fileStream.map(File::getName)
		.filter(s -> s.indexOf(".") != -1) // 확장자가 없으면 제외
		.peek(s -> System.out.printf("filename=%s%n",s))
		.map(String::toUpperCase)
		.peek(s -> System.out.printf("extension=%s%n",s))
		.distinct()
		.forEach(System.out::println);
		
		/*
		 	filename=ex1.java
			extension=EX1.JAVA
			EX1.JAVA
			filename=ex1.bak
			extension=EX1.BAK
			EX1.BAK
			filename=ex2.java
			extension=EX2.JAVA
			EX2.JAVA
			filename=ex1.txt
			extension=EX1.TXT
			EX1.TXT 
		 
		 */
	}

}






