package fr.thales;

import java.lang.reflect.Constructor;

public class AbonnementTest {

	public static void main(String[] args) {
		Constructor<?>[] constructors = Abonnement.class.getConstructors();
		System.out.println(constructors);
	}
}
