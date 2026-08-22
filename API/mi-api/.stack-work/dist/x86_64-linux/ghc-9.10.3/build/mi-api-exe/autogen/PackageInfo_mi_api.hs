{-# LANGUAGE NoRebindableSyntax #-}
{-# OPTIONS_GHC -fno-warn-missing-import-lists #-}
{-# OPTIONS_GHC -w #-}
module PackageInfo_mi_api (
    name,
    version,
    synopsis,
    copyright,
    homepage,
  ) where

import Data.Version (Version(..))
import Prelude

name :: String
name = "mi_api"
version :: Version
version = Version [0,1,0,0] []

synopsis :: String
synopsis = "API REST simple con Scotty"
copyright :: String
copyright = "2026 Tu Nombre"
homepage :: String
homepage = ""
