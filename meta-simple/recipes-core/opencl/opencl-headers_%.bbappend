inherit cmake pkgconfig

unset do_configure[noexec]
unset do_install[noexec]

do_install(){
    cmake_do_install
}