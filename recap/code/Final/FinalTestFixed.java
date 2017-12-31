public class FinalTestFixed {
	public static final class Person {
		private final String name;
		private final Integer age;
		public Person(String name,Integer age) {
			this.name = name;
			this.age = age;
		}
		// The following two methods will give compile errors
		public void setName(String name) {
			this.name = name;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public Integer getAge() {
			return age;
		}
	}
	public static void main(String[] args) {
		Person p = new Person("Ella",1);
		p.setAge(2);
		System.out.println(p.getName() + " is " + p.getAge());
	}
}