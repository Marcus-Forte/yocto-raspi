SUMMARY = "Create systemd networkd wlan0 configuration and hotspot"
DESCRIPTION = "Create systemd networkd wlan0 configuration and hotspot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd
# TODO how to depend on systemd-networkd (packageconfig)
RDEPENDS:${PN} = "systemd wpa-supplicant connman" 

SRC_URI = "file://20-wifi.network \
file://20-hotspot.network \
file://wpa_supplicant-wlan0.conf \
file://enable-wifi.service \
"

FILES:${PN} = "${systemd_unitdir}/network/20-wifi.network \
    ${systemd_unitdir}/network/20-hotspot.network \
    ${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf \
    ${systemd_system_unitdir}/enable-wifi.service \
"
S = "${WORKDIR}"
# UNPACKDIR = "${S}"

SYSTEMD_SERVICE:${PN} = "enable-wifi.service"
SYSTEMD_AUTO_ENABLE = "enable"
# TODO enable `wpa_supplicant@wlan0` as default in image.

do_install() {
    install -d ${D}${systemd_unitdir}/network
    install -m 0644 ${S}/20-wifi.network ${D}${systemd_unitdir}/network
    install -m 0644 ${S}/20-hotspot.network ${D}${systemd_unitdir}/network

    install -d ${D}${sysconfdir}/wpa_supplicant
    install -m 0644 ${S}/wpa_supplicant-wlan0.conf ${D}${sysconfdir}/wpa_supplicant

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${S}/enable-wifi.service ${D}${systemd_system_unitdir}
}
