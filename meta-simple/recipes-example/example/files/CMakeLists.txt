cmake_minimum_required(VERSION 3.10)
project(hello)

option(CONFIG_A "config a" OFF)

add_executable(hello hello.cc)
if(CONFIG_A)
message(WARNING "CONFIG A ENABLED")
target_compile_definitions(hello PUBLIC -DCONFIG_A)
endif()

if(CONFIG_B)
message(WARNING "CONFIG B ENABLED")
target_compile_definitions(hello PUBLIC -DCONFIG_B)
endif()

install(TARGETS hello)