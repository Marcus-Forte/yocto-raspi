SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit cmake

python do_display_banner() {
    bb.plain("***********************************************");
    bb.plain("*                                             *");
    bb.plain("*  Example recipe created by bitbake-layers   *");
    bb.plain("*                                             *");
    bb.plain("***********************************************");
}

SRC_URI = "file://hello.cc \
           file://CMakeLists.txt \
          "

S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

PACKAGECONFIG ??= "CONFIG_A CONFIG_B"
PACKAGECONFIG[CONFIG_A] = "-DCONFIG_A=ON,-DCONFIG_A=OFF"
PACKAGECONFIG[CONFIG_B] = "-DCONFIG_B=ON,-DCONFIG_B=OFF"

addtask display_banner before do_build
