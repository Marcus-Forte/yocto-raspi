FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

DEBIAN_REPO_URL = "http://deb.debian.org/debian buster main"

SRC_URI += " \
    file://debian-repo.conf \
"
do_install:append() {
    install -d ${D}${sysconfdir}/apt/sources.list.d
    install -m 0644 ${WORKDIR}/debian-repo.conf ${D}${sysconfdir}/apt/sources.list.d/
}