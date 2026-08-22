{-# LANGUAGE OverloadedStrings #-}

module Main where

import Web.Scotty
import Data.Text.Lazy (Text)
import qualified Data.Text.Lazy as T

import Data.Aeson (object, (.=), ToJSON, FromJSON, encode, decode)
import GHC.Generics (Generic)
import Network.HTTP.Types.Status (status200, status201, status400, status404)

main :: IO ()
main = do
    putStrLn "🚀 Servidor en http://localhost:5501"
    scotty 5501 $ do
        get "/" $ do
            text "¡Hola Mundo desde Haskell!"

        get "/hello/:name" $ do
            name <- pathParam "name"
            text $ "¡Hola " <> name <> "!"

        post "/post" $ do
            text "post para el http"

        get "/persona/:name/:age" $ do
            name <- pathParam "name"
            age <- pathParam "age" :: ActionM Int -- transformar a int

            text $ "Hola " <> name <> ", tienes " <> T.pack (show age) <> " años"

        get "/msg/:edad" $ do
            edad <- pathParam "edad" :: ActionM Int

            let esMayor = edad >= 18

            json $ object
                [
                    "status" .= ("error" :: Text),
                    "msg" .= ("Giga ninja" :: Text),
                    "code" .= (1193 :: Int),
                    "esMayor" .= (esMayor :: Bool)
                ]