SUMMARY = "Create systemd networkd eth configuration"
DESCRIPTION = "Create systemd networkd eth configuration"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# TODO how to depend on systemd-networkd (packageconfig)
RDEPENDS:${PN} = "systemd" 

SRC_URI = "file://10-eth.network \ 
"

S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

FILES:${PN} = "${systemd_unitdir}/network/10-eth.network"

do_install:append() {
    install -d ${D}${systemd_unitdir}/network
    install -m 0644 ${S}/10-eth.network ${D}${systemd_unitdir}/network
}

