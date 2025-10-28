struct numbers {
	float a;
	float b;
};

program ADD_PROG {
	version ADD_VERS {

		float add(numbers)=1;
        float sub(numbers)=2;
        float mult(numbers)=3;
        float div(numbers)=4;
	}=1;
}=0x23451111;
