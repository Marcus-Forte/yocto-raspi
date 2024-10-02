# Base this image on core-image-minimal
include recipes-core/images/core-image-minimal.bb

inherit swupdate-image

DESCRIPTION = "My custom image."

SRC_URL = "file://sw-description"

PREFERRED_PROVIDER_virtual/bootloader = "u-boot"
RPI_USE_U_BOOT = "1"
PREFERRED_PROVIDER_u-boot-fw-utils = "libubootenv"
IMAGE_FSTYPES:raspberrypi5 = "ext4.gz wic.xz"
SWUPDATE_IMAGES_FSTYPES[my-img-raspberrypi5.rootfs] = ".ext4.gz"

IMAGE_FEATURES:append = " ssh-server-openssh"
# Add 500MB to rootfs.
IMAGE_ROOTFS_EXTRA_SPACE:append = " + 500000" 