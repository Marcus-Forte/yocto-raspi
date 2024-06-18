# Base this image on core-image-base
include recipes-core/images/core-image-minimal.bb

DESCRIPTION = "My custom image."

IMAGE_FSTYPES ?= "tar.gz wic.gz"

# Add 500MB to rootfs.
IMAGE_ROOTFS_EXTRA_SPACE:append = " + 500000" 