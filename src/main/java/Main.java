
import com.epam.spring.homework1.config.BeansConfig;

import com.epam.spring.homework1.pet.Cheetah;
import com.epam.spring.homework1.pet.Pet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
        context.getBean(Pet.class).printPets();
        System.out.println("-------------------");
        Cheetah chtByClass = context.getBean(Cheetah.class);
        Cheetah chtByName = (Cheetah) context.getBean("getBeanCheetahA");

        System.out.println(chtByClass);
        System.out.println(chtByName);



    }


}
