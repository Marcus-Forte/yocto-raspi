FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
PACKAGECONFIG:append = " networkd resolved"

SRC_URI += " \
    file://10-eth.network \
"

do_install:append() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/10-eth.network ${D}${sysconfdir}/systemd/network
}