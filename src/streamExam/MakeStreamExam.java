package streamExam;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MakeStreamExam {

	public static void main(String[] args) {
		
		// 스트림 : 데이터 소스를 상관하지 않고 같은 방식으로 처리하기 할 수 있게한다.
		
		// 스트림은 collection에 stream()이 정의되어 있다.
		// 그래서 list, set는 이 메서드로 스트림을 생성할 수 있다.
		// 스트림은 요소를 모두 읽고 나면 다시 스트림을 사용할 수 없다.
		// 반목문을 메서드에 숨겨서 사용하기 떄문에 코드가 간결하다(내부반복)
		
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Stream<Integer> intStream = list.stream();
		
		// 이 문장을 한 번 더 실행하려면 스트림이 모두 소모되었기 때문에 스트림을 다시 생성해야한다.
		intStream.forEach(System.out::println); // 1,2,3,4,5
		
		// 배열 스트림 만들기
		
		// 문자열 배열
		Stream<String> str1 = Stream.of("a","b","c");
		Stream<String> str2 = Stream.of(new String[] {"A","B","C"});
		Stream<String> str3 = Arrays.stream(new String[] {"a","b","c"});
		Stream<String> str4 = Arrays.stream(new String[] {"a","b","c"}, 0, 3);
		
		
		//int[] numb = new int[] {1,2,3,4};
		// 정수 배열
		IntStream num1 = IntStream.of(1,2,3);
		IntStream num2 = Arrays.stream(new int[] { 1,2,3,4,5}, 0,4);
		
		// 난수 생성
		IntStream intStream2 = new Random().ints(); // 무한스트림
		intStream2.limit(5).forEach(System.out::println); // 5개요소만 출력
		
		IntStream intStream3 = new Random().ints(6); // 유한스트림
		
		// 특정 범위의 정수, 순차 스트림 생성
		IntStream intStream4 = IntStream.range(1, 5); // 1,2,3,4
		IntStream intStream5 = IntStream.rangeClosed(1, 5); // 1,2,3,4,5
		
		// 특정 범위의 난수
		IntStream intStream6 = new Random().ints(5,1,5); // 1 ~ 4중 난수
		intStream6.forEach(System.out::print); // 31412
		
		
		// iterate()는  첫 번째 인자를 매개변수로 두 번쨰 람다식으로 계산된 값을 반환, 계속계산해서 무한스트림 생성
		Stream<Integer> evenStream = Stream.iterate(0, n->n+2);
		
		// generate()는 첫 번째 인자를 매개변수로 두 번쨰 람다식으로 계산된 값을 반환, 한 번 계산하고 다음요소는 계산하지 않음
		// 람다식은 매개변수가 없는 람다식만 허용(Supplier)
		Stream<Double> randomStream = Stream.generate(Math::random);
		
		// 두 메서드는 기본형스트림(IntStream, DoubleStream)으로 참조할 수 없다
		// mapToInt로 스트림 변환을 하면 사용가능
		
		// 빈 스트림
		Stream emptyStream = Stream.empty();
		// 스트림의 요소 갯수 반환
		long count = emptyStream.count();
	}

}
