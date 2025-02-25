# Base this image on core-image-minimal
include recipes-core/images/core-image-minimal.bb

DESCRIPTION = "My custom image."

IMAGE_FSTYPES:raspberrypi5 = "wic.bz2"

IMAGE_FEATURES:append = " ssh-server-openssh"
# Add 500MB to rootfs.
IMAGE_ROOTFS_EXTRA_SPACE:append = " + 500000" 