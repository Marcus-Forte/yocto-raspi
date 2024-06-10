# Base this image on core-image-base
require my-image-base.bb

IMAGE_INSTALL:append = " cuda-samples cuda-toolkit cuda-nvcc-headers apt opencl-icd-loader"

IMAGE_FSTYPES = "wic.gz"
WKS_FILE ?= "jetson-sdcard.wks"