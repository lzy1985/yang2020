package com.yang.study.guava;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;


/**
 * @author lzy
 * @version 1.0.0
 * @date 2018/1/8 上午2:32
 * @Description guava-3.Objects
 */
public class G_3_ObjectsTest {

    /**
     * equal
     * @throws CloneNotSupportedException
     */
    @Test
    public void testEqual_HashCode() throws CloneNotSupportedException {
        System.out.println(Objects.equal("null", "null"));
        System.out.println(Objects.equal("a", "null"));
        System.out.println(Objects.equal("null", "b"));
        System.out.println(Objects.equal("a", "b"));

        G_3_ObjectsTest objectsTest = new G_3_ObjectsTest();
        Student s1 = objectsTest.new Student(1,"张三",20);
        Student s2 = objectsTest.new Student(1,"张三",20);
        Student s3 = (Student) s1.clone();

        System.out.println("---hashCode---");
        System.out.println(Objects.hashCode(s1));
        System.out.println(Objects.hashCode(s2));
        System.out.println(Objects.hashCode(s3));

        System.out.println(Objects.equal(s1, s2));
        System.out.println(Objects.equal(s1, s3));
    }

    /**
     * toStringHelper
     */
    @Test
    public void testToStringHelper(){


        System.out.println(MoreObjects.toStringHelper(this).add("id", 2)
                .add("name", "李四").add("age", 30).toString());


        String str = MoreObjects.toStringHelper(Student.class)
                .add("id",1)
                .add("name","张三")
                .add("age",20).toString();
        System.out.println(str);


        G_3_ObjectsTest objectsTest = new G_3_ObjectsTest();
        Student s1 = objectsTest.new Student(3,"王五",50);
        System.out.println(MoreObjects.toStringHelper(s1).add("id", s1.getId())
                .add("name", s1.getName())
                .add("age", s1.getAge()).toString());

    }

    @Test
    public void testComparable(){
        G_3_ObjectsTest objectsTest = new G_3_ObjectsTest();
        Teacher teacher1 = objectsTest.new Teacher(1,"张三",60);
        Teacher teacher2 = objectsTest.new Teacher(2,"张三",50);
        Teacher teacher3 = objectsTest.new Teacher(3,"张三",70);
        Teacher teacher4 = objectsTest.new Teacher(4,"张三",40);
        Teacher teacher5 = objectsTest.new Teacher(5,"李四",50);
        System.out.println(teacher1.compareTo(teacher2));
        System.out.println(teacher3.compareTo(teacher2));
        System.out.println(teacher4.compareTo(teacher2));
        System.out.println(teacher5.compareTo(teacher2));


    }



    @Data
    @AllArgsConstructor
    class Student implements Cloneable{

        private Integer id;
        private String name;
        private Integer age;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            Student student = (Student) o;

            if (!getId().equals(student.getId())) return false;
            if (!getName().equals(student.getName())) return false;
            return getAge().equals(student.getAge());
        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + getId().hashCode();
            result = 31 * result + getName().hashCode();
            result = 31 * result + getAge().hashCode();
            return result;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }



    @Data
    @AllArgsConstructor
    class Teacher implements Comparable<Teacher>{

        private Integer id;
        private String name;
        private Integer age;

        @Override
        public int compareTo(Teacher o) {
            return ComparisonChain.start().compare(name,o.getName()).compare(age,o.getAge()).result();
        }
    }

}

