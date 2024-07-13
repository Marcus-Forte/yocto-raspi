#include <iostream>



int main() {
    std::cout << "Hello World!!" << std::endl;

    #ifdef CONFIG_A
    std::cout << "Configuration A used!" << std::endl;
    #endif

    #ifdef CONFIG_B
    std::cout << "Configuration B used!" << std::endl;
    #endif
    return 0;
}