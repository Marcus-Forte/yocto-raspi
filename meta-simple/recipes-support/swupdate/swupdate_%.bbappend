FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

PACKAGECONFIG_CONFARGS = ""

SRC_URI += " \
    file://swupdate.cfg \
    "

# additional dependencies required to run swupdate on the target
RDEPENDS:${PN} += "u-boot-fw-utils"

do_install:append() {

    install -d ${D}${sysconfdir}
    install -m 644 ${WORKDIR}/swupdate.cfg ${D}${sysconfdir}
}