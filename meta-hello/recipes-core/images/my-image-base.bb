# Base this image on core-image-base
include recipes-core/images/core-image-minimal.bb

DESCRIPTION = "My custom image."

IMAGE_INSTALL:append = " hellocmake util-linux vim openssh packagegroup-core-buildessential cmake"
IMAGE_FSTYPES ?= "tar.gz wic.gz"

# add 500MB
IMAGE_ROOTFS_EXTRA_SPACE:append = " + 500000" 