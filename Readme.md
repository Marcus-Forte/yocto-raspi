# Yocyo-raspi

Simple, minimal example on building <custom> raspberrypi5 images.

## Usage

1. Open folder in container.
2. Add this layer in bitbake.
3. Select add `MACHINE ?= "raspberrypi5"`
4. `bitbake core-image-base`
 - If problem downloading kernel occurs, look into the log for the
 git command and simply run it from a terminal manually.

## Config

Add to `bblayers.conf`:

- `IMAGE_INSTALL:append = " hellocmake cmake bash apt dpkg"`