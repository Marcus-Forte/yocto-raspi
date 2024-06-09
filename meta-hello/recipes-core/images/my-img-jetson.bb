# Base this image on core-image-base
require my-image-base.bb

IMAGE_INSTALL:append = " cuda-samples"

IMAGE_FSTYPES = "wic"
WKS_FILE ?= "jetson-sdcard.wks"