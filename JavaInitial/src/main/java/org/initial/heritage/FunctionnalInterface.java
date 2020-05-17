package org.initial.heritage;

@FunctionalInterface
public interface FunctionnalInterface {
	void doSomething();
	default int methodWithDefaultImpl() { return 0; }
}
