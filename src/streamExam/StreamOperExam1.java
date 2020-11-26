package streamExam;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperExam1 {

	public static void main(String[] args) {
		
		// 중간연산은 중간에 연산이 되는게 아니라 최종연산에서 출력할 때 연산을 한다
		
		// 지정한 숫자만큼 앞에서 요소 배제
		IntStream intStream = IntStream.rangeClosed(1, 10);
		// 요소의 갯수 제한
		intStream.skip(2).limit(4).forEach(System.out::print); // 3456
		
		System.err.println();
		
		// 조건이 참인 요소만 출력
		intStream = IntStream.rangeClosed(1, 10);
		intStream.filter(i -> i%2==0).forEach(System.out::print); //246810
		
		System.out.println();
		
		// 중복요소 제거해서 출력
		intStream = IntStream.of(new int[] {1,1,1,1,2,2,2,2,3,3,3,4,4,5,6,6,6});
		intStream.distinct().forEach(System.out::print); // 123456
		
		System.out.println();
		
		// 정렬
		// sorted : 내부에 comparable이 있는 요소이어야하고 지정한 방식으로 요소를 정렬
		
		Stream<Student> studentStream = Stream.of(
										new Student("홍길동", 1, 80),
										new Student("김자바", 3, 91),
										new Student("이자바", 2, 57),
										new Student("나자바", 1, 87),
										new Student("육중완", 2, 73)
										);
		// sort()는 요소의 기준으로 정렬한다.(객체같은경우 새로만들기 떄문에 따로 만들어야함)
		// 기본형들은 comparable(디폴트)를 다 가지고 있다
		// sorted에 정렬을 지정하지 않으면 comparable로 정렬하는데 요소가 정렬기준(comparator)가 없다면 예외가 발생
		// Student::getBan은 int의 comparable로 정렬, natrureOrder는 Student의 정렬기준으로 정렬한다.
		studentStream.sorted(Comparator.comparing(Student::getBan)
									   .thenComparing(Comparator.naturalOrder()))
								.forEach(System.out::print);
	
	}

}


class Student implements Comparable<Student>{

	String name;
	int ban;
	int totalScore;
	
	
	
	public Student(String name, int ban, int totalScore) {
		super();
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	
	@Override
	public String toString() {
		return String.format("[%s, %d, %d]", name, ban, totalScore);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBan() {
		return ban;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	@Override
	public int compareTo(Student o) {
		
		return o.totalScore - this.totalScore;
	}	
}
